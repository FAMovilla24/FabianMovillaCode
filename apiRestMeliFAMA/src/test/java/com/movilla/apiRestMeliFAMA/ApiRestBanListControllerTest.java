package com.movilla.apiRestMeliFAMA;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.movilla.apiRestMeliFAMA.controllers.ApiRestBanListController;
import com.movilla.apiRestMeliFAMA.models.BlacklistDTO;
import com.movilla.apiRestMeliFAMA.repositories.IBlacklistDAO;
import com.movilla.apiRestMeliFAMA.service.ParsingService;

@SpringBootTest
class ApiRestBanListControllerTest {

	@Autowired
	private IBlacklistDAO repository;

	@Autowired
	private ApiRestBanListController controller;

	@Autowired
	private ParsingService parsingService;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public List<BlacklistDTO> findAll() {
		List<BlacklistDTO> lBlacklistDTO = new ArrayList<BlacklistDTO>();
		lBlacklistDTO = repository.findAll();
		for (BlacklistDTO lista : lBlacklistDTO) {
			System.out.println(lista.get_id() + "-" + lista.getIp() + "-" + lista.getDate_create());
		}
		return lBlacklistDTO;
	}

	@Test
	public void queryAll() {
		String response = parsingService.parse("http://localhost:3052/banList/queryAll");
		assertThat(response).isNotNull();
	}

	@Test
	public void addOne() throws URISyntaxException {
		try {
			BlacklistDTO employee = postRequest();
		} catch (final HttpStatusCodeException e) {
			System.out.println(e.getMessage());
		}
	}

	public BlacklistDTO postRequest() throws URISyntaxException {
		Random random = new Random();
		String ip = random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "."
				+ random.nextInt(256);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		URI uri = new URI("http://localhost:3052/banList/addOne");
		BlacklistDTO lBlacklistDTO = new BlacklistDTO();
		lBlacklistDTO.setIp(ip);
		HttpEntity<BlacklistDTO> httpEntity = new HttpEntity<>(lBlacklistDTO, headers);
		RestTemplate restTemplates = new RestTemplate();
		BlacklistDTO employee = restTemplates.postForObject(uri, httpEntity, BlacklistDTO.class);
		return employee;
	}
}
