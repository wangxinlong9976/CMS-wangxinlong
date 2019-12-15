package com.wxl.cms.common;

public class ConditionsArticleManager {
	
	
	private Integer currPage=1;
	private String keyWord;
	
	private Integer channel;
	private Integer category;
	private Integer status;
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public ConditionsArticleManager(Integer currPage, String keyWord, Integer channel, Integer category,
			Integer status) {
		super();
		this.currPage = currPage;
		this.keyWord = keyWord;
		this.channel = channel;
		this.category = category;
		this.status = status;
	}
	public ConditionsArticleManager() {
		super();
	}
	@Override
	public String toString() {
		return "ConditionsArticleManager [currPage=" + currPage + ", keyWord=" + keyWord + ", channel=" + channel
				+ ", category=" + category + ", status=" + status + "]";
	}
	
	
	
}
