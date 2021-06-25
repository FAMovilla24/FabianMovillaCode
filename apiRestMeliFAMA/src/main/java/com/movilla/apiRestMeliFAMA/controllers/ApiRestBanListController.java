package com.movilla.apiRestMeliFAMA.controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movilla.apiRestMeliFAMA.exception.FailedAddException;
import com.movilla.apiRestMeliFAMA.exception.FailedDeleteException;
import com.movilla.apiRestMeliFAMA.exception.FailedQueryException;
import com.movilla.apiRestMeliFAMA.exception.IpInvalidException;
import com.movilla.apiRestMeliFAMA.exception.ResourceDuplicateException;
import com.movilla.apiRestMeliFAMA.exception.ResourceNotFoundException;
import com.movilla.apiRestMeliFAMA.models.BlacklistDTO;
import com.movilla.apiRestMeliFAMA.repositories.IBlacklistDAO;

@RestController
@RequestMapping("/banList")
public class ApiRestBanListController {
		
	@Autowired
	private IBlacklistDAO repository;
	
	@GetMapping(path="/queryAll")
	public ResponseEntity<List<BlacklistDTO>> queryAll () throws FailedQueryException {
		try {
			return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
		} catch (Exception exc) {
			throw new FailedQueryException("Falla metodo queryAll " + exc.getMessage());
		}
	}
	
	@GetMapping(path="/queryOneByIp")
	public ResponseEntity<BlacklistDTO> queryOneByIp (@RequestParam (value="direccion") String direccionIp) throws ResourceNotFoundException, FailedQueryException, IpInvalidException {	
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
		if(blacklistDTO == null) {
			throw new ResourceNotFoundException("No existe la IP " + direccionIp + " en el BlackList");
		}
		return new ResponseEntity<>(blacklistDTO, HttpStatus.OK);
	}
	
	@DeleteMapping( value = "/deleteOneByIp", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteOneByIp (@RequestBody BlacklistDTO inBlacklistDTO) throws FailedDeleteException, IpInvalidException {
		InetAddressValidator validator = InetAddressValidator.getInstance();
        if (!validator.isValidInet4Address(inBlacklistDTO.getIp())) {
            throw new IpInvalidException("La direccion IP  " + inBlacklistDTO.getIp() + " es invalida");
        }
		BlacklistDTO blacklistDTO = new BlacklistDTO();
		blacklistDTO = repository.queryOneByIp(inBlacklistDTO.getIp());
		if (blacklistDTO == null)  {
			throw new FailedDeleteException("No existe la IP " + inBlacklistDTO.getIp() + " en el BlackList");
		} else {
			try {
				repository.deleteOneByIp(inBlacklistDTO.getIp());					
			} catch (Exception exc) {
				throw new FailedDeleteException("Falla metodo deleteOneByIp " + exc.getMessage());
			}
		}
		return new ResponseEntity(HttpStatus.OK);
	}
			
	@PostMapping( value = "/addOne", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BlacklistDTO> addOne (@RequestBody BlacklistDTO inBlacklistDTO) throws FailedAddException, ResourceDuplicateException, IpInvalidException {
		InetAddressValidator validator = InetAddressValidator.getInstance();
        if (!validator.isValidInet4Address(inBlacklistDTO.getIp())) {
            System.out.print("The IP address " + inBlacklistDTO.getIp() + " is invalid");
            throw new IpInvalidException("La direccion IP  " + inBlacklistDTO.getIp() + " es invalida");
        }
		BlacklistDTO blacklistDTO = new BlacklistDTO();
		blacklistDTO = repository.queryOneByIp(inBlacklistDTO.getIp());
		if (blacklistDTO != null)  {
			throw new ResourceDuplicateException("Ya existe la IP " + inBlacklistDTO.getIp() + " en el BlackList");
		} else {				
			try {
				blacklistDTO = new BlacklistDTO();
				blacklistDTO.setIp(inBlacklistDTO.getIp());
				blacklistDTO.setDate_create(new Date());	
				blacklistDTO = repository.insert(blacklistDTO);					
			} catch (Exception exc) {
				throw new FailedAddException("Falla metodo addOne " + exc.getMessage());
			}	
		}			
		return new ResponseEntity<>(blacklistDTO, HttpStatus.CREATED);
	}
	
}
