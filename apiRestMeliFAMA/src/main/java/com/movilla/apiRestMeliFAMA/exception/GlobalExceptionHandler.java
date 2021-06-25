package com.movilla.apiRestMeliFAMA.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(390, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FailedQueryException.class)
	public ResponseEntity<?> failedQueryException(FailedQueryException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(391, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(FailedDeleteException.class)
	public ResponseEntity<?> failedDeleteException(FailedDeleteException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(392, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceDuplicateException.class)
	public ResponseEntity<?> resourceDuplicateException(ResourceDuplicateException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(393, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.FOUND);
	}

	@ExceptionHandler(FailedAddException.class)
	public ResponseEntity<?> FailedAddException(FailedAddException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(394, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IpBlackListException.class)
	public ResponseEntity<?> ipBlackListException(IpBlackListException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(395, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(JsonException.class)
	public ResponseEntity<?> jsonException(JsonException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(396, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IpInvalidException.class)
	public ResponseEntity<?> ipInvalidException(IpInvalidException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(397, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(500, new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
