package com.movilla.apiRestMeliFAMA.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Currency {
	
	@JsonProperty("code")
	private String code	;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("symbol")
	private String symbol;
	
	private String valorUSD;
	
	private String valorEUR;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getValorUSD() {
		return valorUSD;
	}

	public void setValorUSD(String valorUSD) {
		this.valorUSD = valorUSD;
	}

	public String getValorEUR() {
		return valorEUR;
	}

	public void setValorEUR(String valorEUR) {
		this.valorEUR = valorEUR;
	}
	
	

}
