package com.ivan.exception;

/**
 * 数据非法异常
 */
public class DataInvalidException extends Exception {

	private static final long serialVersionUID = -8646753253800127279L;

	public DataInvalidException(Throwable cause) {
		super(cause);
	}

	public DataInvalidException(String message) {
		super(message);
	}

	public DataInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

}
