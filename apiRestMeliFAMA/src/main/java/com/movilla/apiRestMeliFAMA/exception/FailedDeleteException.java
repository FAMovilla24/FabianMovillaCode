package com.movilla.apiRestMeliFAMA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FailedDeleteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public FailedDeleteException(String message) {
		super(message);
	}

}
