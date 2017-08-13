package com.cn.spider;

import com.cn.comm.BaseEntity;

public class MusicVo extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String name;
	private String author;
	private String category;
	private String url;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
