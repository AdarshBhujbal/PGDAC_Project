package com.cdac.oralcaremanagement.dto;

public class Response {
	private String message;

	public Response() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + "]";
	}

}
