package com.nsc.tsui.exceptions;

public class TSUIServiceException extends Exception {

	String exceptionMsg;

	TSUIServiceException() {
		super();
	}

	TSUIServiceException(String exceptionMsg) {
		super(exceptionMsg);
		this.exceptionMsg = exceptionMsg;
	}

	TSUIServiceException(String exceptionMsg, Throwable throwable) {
		super(exceptionMsg, throwable);
		this.exceptionMsg = exceptionMsg;
	}

	public String toString() {
		return exceptionMsg;
	}
}
