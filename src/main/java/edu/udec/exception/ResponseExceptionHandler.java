package edu.udec.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrrorWrapper> manejadorException(Exception ex,
			WebRequest request) {
			 ErrrorWrapper er = new ErrrorWrapper(ex.getMessage(), request.getDescription(false));
		   return new ResponseEntity<ErrrorWrapper>(er, HttpStatus.INTERNAL_SERVER_ERROR);					
	}
	
	
	@ExceptionHandler(NotFoundModelException.class)
	public final ResponseEntity<ErrrorWrapper> manejadorModelException(NotFoundModelException ex,
			WebRequest request) {
			 ErrrorWrapper er = new ErrrorWrapper(ex.getMessage(), request.getDescription(false));
		   return new ResponseEntity<ErrrorWrapper>(er, HttpStatus.NOT_FOUND);					
	}
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ErrrorWrapper> manejadorNullPointerException(NullPointerException ex,
			WebRequest request) {
			 ErrrorWrapper er = new ErrrorWrapper(ex.getMessage(), request.getDescription(false));
		   return new ResponseEntity<ErrrorWrapper>(er, HttpStatus.INTERNAL_SERVER_ERROR);					
	}
		
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrrorWrapper er = new ErrrorWrapper(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrrorWrapper er = new ErrrorWrapper(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(er, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrrorWrapper er = new ErrrorWrapper(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);		
	}	
	
	
	
	
	
	
	
	

}
