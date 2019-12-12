package com.wxl.cms.pojo;

public class Conditions {
	private Integer currPage=1;
	private String keyWord;
	private String nickName;
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Conditions() {
		super();
	}
	@Override
	public String toString() {
		return "Conditions [currPage=" + currPage + ", keyWord=" + keyWord + ", nickName=" + nickName + "]";
	}
	
}
