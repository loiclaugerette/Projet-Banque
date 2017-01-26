package com.adaming.myapp.exception;

public class AlreadyLinkedException extends Exception {

	public AlreadyLinkedException() {
	}

	public AlreadyLinkedException(String message) {
		super(message);
	}

	public AlreadyLinkedException(Throwable cause) {
		super(cause);
	}

	public AlreadyLinkedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlreadyLinkedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
