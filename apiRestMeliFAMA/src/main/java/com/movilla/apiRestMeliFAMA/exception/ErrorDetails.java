package com.movilla.apiRestMeliFAMA.exception;

import java.util.Date;

public class ErrorDetails {
	
	private int code; 
	private Date timestamp;
	private String message;
	private String details;
	
	public ErrorDetails(int code, Date timestamp, String message, String details) {
		super();
		this.code = code;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
