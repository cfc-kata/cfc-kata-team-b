package com.cfckata.exception;

import lombok.Data;

@Data
public class RepaymentException extends RuntimeException{

	private String code;
	
	private String codeMessage;
	
	public RepaymentException() {}
	
	public RepaymentException(String message){
		super(message);
		this.codeMessage = message;
	}
	
	public RepaymentException(String code,String message){
		super(code+message);
		this.code = code;
		this.codeMessage = message;
	}
	
	@Override
    public String getMessage() {
        return code+codeMessage;
    }
}
