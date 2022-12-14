package br.com.neki.proj01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = { MayNotBeNullException.class })
	protected ResponseEntity<Object> notNull(MayNotBeNullException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(ex.getLocalizedMessage());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(value = { ItemNotFoundException.class })
	protected ResponseEntity<Object> naoEncontrado(ItemNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		apiError.setDebugMessage(ex.getLocalizedMessage());
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}