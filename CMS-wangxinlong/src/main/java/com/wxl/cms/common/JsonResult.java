package com.wxl.cms.common;

public class JsonResult {
	private boolean result;
	private Integer errorCode;
	private String message;
	
	
	public static JsonResult success() {
		return new JsonResult(true, 200, null);
	}
	public static JsonResult fail(Integer errorCode,String message) {
		return new JsonResult(false, errorCode, message);
	}
	
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public JsonResult() {
		super();
	}
	
	public JsonResult(boolean result, Integer errorCode, String message) {
		super();
		this.result = result;
		this.errorCode = errorCode;
		this.message = message;
	}
	@Override
	public String toString() {
		return "JsonResult [result=" + result + ", errorCode=" + errorCode + ", message=" + message + "]";
	}
}
