package com.cfckata.response;

import lombok.Data;
@Data
public class ErrorResponse {
	
	//错误码
	private String errorCode;
	//错误信息
	private String errorMessage;
	
	public ErrorResponse(){
	}
	
	public ErrorResponse(String errorCode,String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
}
