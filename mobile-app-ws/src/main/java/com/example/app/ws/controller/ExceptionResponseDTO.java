package com.example.app.ws.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExceptionResponseDTO {
	
	@JsonIgnore
	private final HttpStatus httpStatus;
	private final String message;
	private final Date date;
	
	public Date getDate() {
		return date;
	}
	public ExceptionResponseDTO(HttpStatus httpStatus, String message, Date date) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.date = date;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public String getMessage() {
		return message;
	}

}
