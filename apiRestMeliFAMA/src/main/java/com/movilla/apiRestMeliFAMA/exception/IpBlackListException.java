package com.movilla.apiRestMeliFAMA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class IpBlackListException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IpBlackListException(String message) {
		super(message);
	}

}
