package com.lcwd.user.service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.payload.APIResponce;


@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<APIResponce> handlerForResourceNotFound(UserNotFoundException exp)
	{
		String message = exp.getMessage();
		APIResponce responce = APIResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<APIResponce>(responce,HttpStatus.NOT_FOUND);
		
		
		
	}
}
