package com.mycompany.common.exception;

import org.springframework.http.HttpStatus;

public class MyCompanyException extends RuntimeException {
	private static final long serialVersionUID = -2169547160291888849L;

	private final String msgKey;
	private final Object[] args;
	private final HttpStatus status;

	protected MyCompanyException(String msgKey, HttpStatus status, Object... args) {
		super(msgKey);
		this.msgKey = msgKey;
		this.status = status;
		this.args = args;
	}

	public String getMessageKey() {
		return msgKey;
	}

	public Object[] getArgs() {
		return args;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
