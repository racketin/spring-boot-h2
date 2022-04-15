package com.rac.halodoc.exception;

public class InvalidAtributeTypeException extends InvalidDocumentException {
	public InvalidAtributeTypeException(String message) {
		super(message);
	}

	public InvalidAtributeTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAtributeTypeException(Throwable cause) {
		super(cause);
	}

	protected InvalidAtributeTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
