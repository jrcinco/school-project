package com.school.web.controller.advice;

import com.school.web.common.exception.ClientErrorException;
import com.school.web.common.payload.OperationError;
import com.school.web.common.payload.DetailError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@ControllerAdvice(basePackages = {"com.school.web.controller"} )
public class GlobalControllerAdvice {
	  /**
		 * @return 400 code status
		 */
	  @ExceptionHandler(ClientErrorException.class)
	  public ResponseEntity<DetailError> responseToClientError(ClientErrorException exception) {
			  exception.printStackTrace();
				return new ResponseEntity<>(
						new DetailError(exception.getCode(), exception.getMessage(), 
						exception.getMessages()), 
						HttpStatus.BAD_REQUEST);
	  }
}
