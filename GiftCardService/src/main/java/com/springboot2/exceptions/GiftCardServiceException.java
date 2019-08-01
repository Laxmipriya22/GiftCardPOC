package com.springboot2.exceptions;

public class GiftCardServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GiftCardServiceException(String message) {
		super(message);
	}

	public GiftCardServiceException(String message, Throwable t) {
		super(message, t);
	}
	public GiftCardServiceException(Throwable t) {
		super(t);
	}

}
