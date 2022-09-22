package com.example.demo.ControllerAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Response.ErrorResponse;

@RestControllerAdvice
public class GeneralExceptionHandler { 
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(Exception.class)
	public ErrorResponse handleException(Exception exe)
	{
		ErrorResponse r=new ErrorResponse();
		r.setErrocode("General"); 
		r.setDescription(exe.getMessage());
		r.setException(exe);
		return  r; 
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleExceptions(MethodArgumentNotValidException ex)
	{
		BindingResult bundingResult=ex.getBindingResult();
		List<ObjectError> list=bundingResult.getAllErrors();
		
		Map<String, String> map=new HashMap<>();
		for (ObjectError objectError : list) {
			map.put(((FieldError)objectError).getField(),objectError.getDefaultMessage());
		}
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		
    }


}