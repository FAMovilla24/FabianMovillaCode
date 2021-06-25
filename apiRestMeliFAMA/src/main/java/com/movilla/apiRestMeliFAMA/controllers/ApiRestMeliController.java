package com.movilla.apiRestMeliFAMA.controllers;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movilla.apiRestMeliFAMA.domain.Country;
import com.movilla.apiRestMeliFAMA.domain.CountryInformation;
import com.movilla.apiRestMeliFAMA.domain.Currency;
import com.movilla.apiRestMeliFAMA.domain.ExchangeConverte;
import com.movilla.apiRestMeliFAMA.exception.FailedQueryException;
import com.movilla.apiRestMeliFAMA.exception.IpBlackListException;
import com.movilla.apiRestMeliFAMA.exception.IpInvalidException;
import com.movilla.apiRestMeliFAMA.exception.JsonException;
import com.movilla.apiRestMeliFAMA.exception.ResourceNotFoundException;
import com.movilla.apiRestMeliFAMA.models.BlacklistDTO;
import com.movilla.apiRestMeliFAMA.repositories.IBlacklistDAO;
import com.movilla.apiRestMeliFAMA.service.ParsingService;

@RestController
@RequestMapping("/ip")
public class ApiRestMeliController {

	@Autowired
	private IBlacklistDAO repository;

	@Autowired
	private ParsingService parsingService;

	@Autowired
	private Environment env;

	@GetMapping(path = "/consultarInfo")
	public ResponseEntity<CountryInformation> obtenerInformacion(@RequestParam(value = "direccion") String direccionIp)
			throws ResourceNotFoundException, FailedQueryException, IpBlackListException, JsonException, IpInvalidException {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        if (!validator.isValidInet4Address(direccionIp)) {
            throw new IpInvalidException("La direccion IP  " + direccionIp + " es invalida");
        }		
		BlacklistDTO blacklistDTO = new BlacklistDTO();
		blacklistDTO = repository.queryOneByIp(direccionIp);
		try {
			blacklistDTO = repository.queryOneByIp(direccionIp);
		} catch (Exception exc) {
			throw new FailedQueryException("Falla metodo queryOneByIp " + exc.getMessage());
		}
		if (blacklistDTO != null) {
			throw new IpBlackListException("La IP " + direccionIp + " esta en el BlackList con el ID "
					+ blacklistDTO.get_id() + " con fecha de creacion " + blacklistDTO.getDate_create());
		}
		String endpointApi = env.getProperty("end.point.api.info.ip");
		String endpointCountry = env.getProperty("end.point.api.info.country");
		String endpointExchange = env.getProperty("end.point.api.exchange.convert");
		CountryInformation countryInformation = null;
		Country country = null;
		ExchangeConverte exchangeConverte = null;
		endpointApi = endpointApi + direccionIp;
		String response = parsingService.parse(endpointApi);
		try {
			country = new ObjectMapper().readValue(response, Country.class);
			if (country.getCountryCode3() != null) {
				response = parsingService.parse(endpointCountry + country.getCountryCode3() + "?fields=currencies");
				countryInformation = new ObjectMapper().readValue(response, CountryInformation.class);
				countryInformation.setCountry(country);
				if (countryInformation.getCurrencies().size() > 0) {
					for (Currency currencies : countryInformation.getCurrencies()) {
						response = parsingService.parse(endpointExchange + currencies.getCode() + "&to=EUR");
						exchangeConverte = new ObjectMapper().readValue(response, ExchangeConverte.class);
						currencies.setValorEUR(exchangeConverte.getResult());
						response = parsingService.parse(endpointExchange + currencies.getCode() + "&to=USD");
						exchangeConverte = new ObjectMapper().readValue(response, ExchangeConverte.class);
						currencies.setValorUSD(exchangeConverte.getResult());
					}
				} else {
					throw new ResourceNotFoundException("No existe informacion sobre las monedas para el pais "
							+ countryInformation.getCountry().getCountryName());
				}
			} else {
				throw new ResourceNotFoundException("No existe informacion general para la IP " + direccionIp);
			}
		} catch (JsonMappingException e) {
			throw new JsonException("Fallo al Mapear el objeto JSON " + e.getMessage());
		} catch (JsonProcessingException e) {
			throw new JsonException("Fallo al Procesar el objeto JSON " + e.getMessage());
		}
		return new ResponseEntity<>(countryInformation, HttpStatus.OK);
	}
}
