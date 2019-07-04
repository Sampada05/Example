package com.customer.profile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.customer.profile.dto.ResponseDto;

@ControllerAdvice
class GlobalExceptionHandler {
	
	@ExceptionHandler(RecordNotFound.class)
	public ResponseEntity<ResponseDto> handleException(RecordNotFound ex){
		ResponseDto rs=new ResponseDto();
		rs.setMessage(ex.getMessage());
		return new ResponseEntity<>(rs,HttpStatus.NOT_FOUND);
	}

}
