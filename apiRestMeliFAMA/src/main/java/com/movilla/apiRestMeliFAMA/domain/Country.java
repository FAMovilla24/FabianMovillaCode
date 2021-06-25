package com.movilla.apiRestMeliFAMA.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Country {
	
	@JsonProperty("countryCode")
	private String countryCode;
	
	@JsonProperty("countryCode3")
	private String countryCode3;

	@JsonProperty("countryName")
	private String countryName;
	
	@JsonProperty("countryEmoji")
	private String countryEmoji;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode3() {
		return countryCode3;
	}

	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryEmoji() {
		return countryEmoji;
	}

	public void setCountryEmoji(String countryEmoji) {
		this.countryEmoji = countryEmoji;
	}
	
}
