package com.empman.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> invalidCredientials(InvalidCredentialsException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<String> resourceAlreadyExists(ResourceAlreadyExistsException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<String> somethingWentWrongException(SomethingWentWrongException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
