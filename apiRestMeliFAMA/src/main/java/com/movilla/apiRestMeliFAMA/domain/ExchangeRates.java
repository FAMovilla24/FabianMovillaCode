package com.movilla.apiRestMeliFAMA.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRates {
	
	@JsonProperty("EUR")
	private String eur;
	
	@JsonProperty("USD")
	private String usd;

	public String getEur() {
		return eur;
	}

	public void setEur(String eur) {
		this.eur = eur;
	}

	public String getUsd() {
		return usd;
	}

	public void setUsd(String usd) {
		this.usd = usd;
	}

}
