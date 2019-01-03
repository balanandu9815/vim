package com.balu.vim.model;

import javax.xml.bind.annotation.XmlRootElement;
//Class for Custom Response Handing
@XmlRootElement(name = "Response")
public class ApiResponse {
	private int respCode;
	private String respMessage;

	public ApiResponse() {

	}

	public ApiResponse(int respCode, String message) {
		this.respCode = respCode;
		this.respMessage = message;
	}

	public int getRespCode() {
		return respCode;
	}

	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}

	public String getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(String message) {
		this.respMessage = message;
	}

}