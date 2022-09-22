package com.example.demo.Response;

public class ErrorResponse {
	
	private String errocode;
	private String description;
	private Exception exception; 
	public String getErrocode() { 
		return errocode; 
	}
	public void setErrocode(String errocode) {
		this.errocode = errocode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	

}
