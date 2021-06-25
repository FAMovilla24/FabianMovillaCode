package com.movilla.apiRestMeliFAMA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class JsonException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public JsonException(String message) {
		super(message);
	}

}
