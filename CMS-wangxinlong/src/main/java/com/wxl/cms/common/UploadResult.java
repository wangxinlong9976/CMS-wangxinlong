package com.wxl.cms.common;

public class UploadResult {
	
	private String message;
	private Integer error;
	public String getmessage() {
		return message;
	}
	public void setmessage(String message) {
		this.message = message;
	}
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public UploadResult(String message, Integer error) {
		super();
		this.message = message;
		this.error = error;
	}
	public UploadResult() {
		super();
	}
	@Override
	public String toString() {
		return "UploadResult [message=" + message + ", error=" + error + "]";
	}
}
