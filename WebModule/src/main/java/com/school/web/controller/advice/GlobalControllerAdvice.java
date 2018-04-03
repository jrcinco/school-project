package com.school.web.controller.advice;

import com.school.web.common.exception.ClientErrorException;
import com.school.web.common.exception.ApplicationException;
import com.school.web.common.payload.BasicError;
import com.school.web.common.payload.DetailError;
import com.school.web.util.PropertiesUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice(basePackages = {"com.school.web.controller"} )
public class GlobalControllerAdvice {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	* @return 400 code status - BAD_REQUEST
	*/
	@ExceptionHandler(ClientErrorException.class)
	public ResponseEntity<DetailError> responseToClientError(ClientErrorException exception) {
		logger.info("[GlobalControllerAdvice.responseToClientError] printStackTrace: ");
		exception.printStackTrace();
		return new ResponseEntity<>(
				new DetailError(exception.getCode(), exception.getMessage(), 
				exception.getMessages()), 
				HttpStatus.BAD_REQUEST);
	}

	/**
	* @return 400 code status - BAD_REQUEST
	*/
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<BasicError> responseToApplicationError(ApplicationException exception) {
		logger.info("[GlobalControllerAdvice.responseToApplicationError] printStackTrace: ");
		exception.printStackTrace();
		return new ResponseEntity<>(
				new BasicError(exception.getCode(), exception.getMessage()), 
				HttpStatus.BAD_REQUEST);
	}

	/**
	* @return 500 code status - INTERNAL_SERVER_ERROR
	* ER001=Application exception. Please contact your administrative personnel for technical support.
	*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<BasicError> responseToServerError(Exception exception) {
		logger.info("[GlobalControllerAdvice.responseToServerError] printStackTrace: ");
		exception.printStackTrace();
		String code = "ER001";
		return new ResponseEntity<>(
				new BasicError(code, PropertiesUtil.getProperties().getProperty(code)), 
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
