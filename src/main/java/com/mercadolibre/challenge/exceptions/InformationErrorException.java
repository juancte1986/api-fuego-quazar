package com.mercadolibre.challenge.exceptions;

public class InformationErrorException extends RuntimeException {

	private static final long serialVersionUID = -3425840250606194877L;
	
	public InformationErrorException(String message) {
		super(message);
	}
}
