package com.movilla.apiRestMeliFAMA;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movilla.apiRestMeliFAMA.controllers.ApiRestBanListController;
import com.movilla.apiRestMeliFAMA.repositories.IBlacklistDAO;
import com.movilla.apiRestMeliFAMA.service.ParsingService;

@SpringBootTest
class ApiRestMeliControllerTest {

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
	public void consultarInfo() {
		String response = parsingService.parse("http://localhost:3052/ip/consultarInfo/?direccion=200.14.48.0");
		assertThat(response).isNotNull();
	}

}
