package com.aem.romannumeralconverter.handler;

import com.aem.romannumeralconverter.constants.RomanNumeralConverterConstants;
import com.aem.romannumeralconverter.exception.InvalidInputRangeException;
import com.aem.romannumeralconverter.exception.InvalidMaxNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputRangeException.class)
    public ResponseEntity<String> invalidInputRangeException(InvalidInputRangeException exception) {
    	return new ResponseEntity<String>(RomanNumeralConverterConstants.INVALID_INPUT_RANGE_ERROR_MESSAGE, HttpStatus.BAD_REQUEST);

    }
    
    @ExceptionHandler(InvalidMaxNumberException.class) 
    public ResponseEntity<String> invalidMaxNumberException(Exception exception) { 
    	return new ResponseEntity<String>(RomanNumeralConverterConstants.INPUT_ERROR_MESSAGE,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> invalidInputException(Exception exception) {
        return new ResponseEntity<String>(RomanNumeralConverterConstants.INVALID_INPUT_ERROR_MESSAGE, HttpStatus.BAD_REQUEST);

    } 
	 
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> invalidUriException(Exception exception) {
        return new ResponseEntity<String>(RomanNumeralConverterConstants.INVALID_URI_ERROR_MESSAGE, HttpStatus.BAD_REQUEST);

    }
}
