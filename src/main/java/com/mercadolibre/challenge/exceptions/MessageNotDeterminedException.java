package com.mercadolibre.challenge.exceptions;

public class MessageNotDeterminedException extends RuntimeException {

	private static final long serialVersionUID = -8489764315809844209L;
	
	public MessageNotDeterminedException(String message) {
		super(message);
	}
}
