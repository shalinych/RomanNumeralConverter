package com.aem.romannumeralconverter.exception;

import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
public class InvalidMaxNumberException extends RuntimeException {


	public InvalidMaxNumberException(String inputErrorMessage) {

	}

	private String errorMessage;

}
