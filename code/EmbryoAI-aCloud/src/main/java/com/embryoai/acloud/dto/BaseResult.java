package com.embryoai.acloud.dto;

public class BaseResult {
	private String code;
	private String message;
	private Object data;
	
	public BaseResult() {}
	public BaseResult(String code,String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
