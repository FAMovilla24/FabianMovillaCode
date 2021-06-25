package com.movilla.apiRestMeliFAMA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IpInvalidException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IpInvalidException(String message) {
		super(message);
	}

}
