package com.wxl.cms.pojo;

public class Vote_content {
	private Integer id;
	
	private String content;
	
	private String title;

	@Override
	public String toString() {
		return "Vote_content [id=" + id + ", content=" + content + ", title=" + title + "]";
	}

	public Vote_content(Integer id, String content, String title) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
	}

	public Vote_content() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
