package com.wxl.cms.common;

public class Conditions {
	//公共字段
	private Integer currPage=1;
	private String keyWord;
	
	//用户管理模块的昵称字段
	private String nickName;
	
	//文章管理模块的查询条件
	
	
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
	

	public Conditions(Integer currPage, String keyWord, String nickName) {
		super();
		this.currPage = currPage;
		this.keyWord = keyWord;
		this.nickName = nickName;;
	}
	public Conditions() {
		super();
	}
	@Override
	public String toString() {
		return "Conditions [currPage=" + currPage + ", keyWord=" + keyWord + ", nickName=" + nickName + "]";
	}
	
	
}
