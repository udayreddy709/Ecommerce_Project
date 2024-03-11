package org.jsp.ecommerceapp.exception;

import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EcommerceAppExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>> handlerICE(InvalidCredentialsException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setBody("cannot find Merchant");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlerINFE(IdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setBody("cannot find Merchant");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
