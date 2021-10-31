package com.aem.romannumeralconverter.exception;

import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
public class InvalidInputRangeException extends RuntimeException {


	public InvalidInputRangeException(String inputErrorMessage) {

	}

	private String errorMessage;

}
