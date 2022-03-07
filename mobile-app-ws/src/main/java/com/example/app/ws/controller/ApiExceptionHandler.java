package com.example.app.ws.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// this will intercept all exception is controller level and tacth here to send proper json response data that we want
// here exception traces is not printed in log
@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(NullPointerException x, HttpServletRequest request) {
		
		// getLocalizedMessage is message we put in ("") while throwing exception. if nothing provided while throwing this is null
		return new ResponseEntity<Object>(new ExceptionResponseDTO(HttpStatus.NOT_FOUND, x.getLocalizedMessage(), new Date()), HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound( UserNotFoundException e) {
		
		return new ResponseEntity<Object>(new ExceptionResponseDTO(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), new Date()), HttpStatus.NOT_FOUND);
	}

}
