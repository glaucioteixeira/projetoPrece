package br.com.cenarioesolucao.projetoPrece.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.cenarioesolucao.projetoPrece.service.exception.AuthorizationException;
import br.com.cenarioesolucao.projetoPrece.service.exception.DataIntegrityException;
import br.com.cenarioesolucao.projetoPrece.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError body = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), e.getCause(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		StandardError body = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getCause(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError body = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Error de validação", e.getCause(), System.currentTimeMillis());
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			body.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
		StandardError body = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), e.getCause(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
	}
}
