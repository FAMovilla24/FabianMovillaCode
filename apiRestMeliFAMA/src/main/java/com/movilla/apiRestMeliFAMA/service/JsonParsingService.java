package com.movilla.apiRestMeliFAMA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonParsingService implements ParsingService {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String parse(String url) {
		return restTemplate.getForObject(url, String.class);
	}

}
