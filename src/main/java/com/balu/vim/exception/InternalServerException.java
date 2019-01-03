package com.balu.vim.exception;

public class InternalServerException extends VehicleServiceException {

	private static final long serialVersionUID = 1L;
	private int errorCode;

	public InternalServerException(int code, String msg) {
		super(code, msg);
		this.errorCode = code;
	}
}