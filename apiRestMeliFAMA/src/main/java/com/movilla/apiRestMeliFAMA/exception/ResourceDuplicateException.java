package com.movilla.apiRestMeliFAMA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class ResourceDuplicateException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ResourceDuplicateException(String message) {
		super(message);
	}
	
}