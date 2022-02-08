package com.ivan.exception;

/**
 * 数据缺失异常
 */
public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = -8646753253800127279L;

	public DataNotFoundException(Throwable cause) {
		super(cause);
	}

	public DataNotFoundException(String message) {
		super(message);
	}

	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
