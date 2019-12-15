package com.wxl.cms.common;

public class UploadResult {
	
	private String url;
	private Integer error;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public UploadResult(String url, Integer error) {
		super();
		this.url = url;
		this.error = error;
	}
	public UploadResult() {
		super();
	}
	@Override
	public String toString() {
		return "UploadResult [url=" + url + ", error=" + error + "]";
	}
}
