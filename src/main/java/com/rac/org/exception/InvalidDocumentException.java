package com.rac.halodoc.exception;

public class InvalidDocumentException extends RuntimeException {
	public InvalidDocumentException(String message) {
		super(message);
	}

	public InvalidDocumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDocumentException(Throwable cause) {
		super(cause);
	}

	protected InvalidDocumentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
