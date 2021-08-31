package com.assignment.one.Exceptionhandling;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	   public ResponseEntity<Object> exception(DataIntegrityViolationException exception) {
	      return new ResponseEntity<>("Id not found to update", HttpStatus.NOT_FOUND);
	   }
	@ExceptionHandler(value =EmptyResultDataAccessException.class)
	   public ResponseEntity<Object> exception2(EmptyResultDataAccessException exception) {
	      return new ResponseEntity<>("Id not found to delete", HttpStatus.NOT_FOUND);
	   }
	
}

