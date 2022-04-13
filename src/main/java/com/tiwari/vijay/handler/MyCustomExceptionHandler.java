package com.tiwari.vijay.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tiwari.vijay.exception.ToyNotFoundException;
import com.tiwari.vijay.model.ErrorMessage;

@RestControllerAdvice
public class MyCustomExceptionHandler {
	
	@ExceptionHandler(ToyNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleProductNotFound(
			ToyNotFoundException tnfe) 
	{
		
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						tnfe.getMessage(), 
						"TOYSHOP", 
						new Date().toString(),
						"DATA NOT FOUND"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
