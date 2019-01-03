package com.balu.vim.exception;

public class BadRequestException extends VehicleServiceException {
	private static final long serialVersionUID = 1L;
	private int errorCode;

	public BadRequestException(int code, String msg) {
		super(code, msg);
		this.errorCode = code;
	}
}