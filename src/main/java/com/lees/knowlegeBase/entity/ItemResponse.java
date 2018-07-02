package com.lees.knowlegeBase.entity;

import java.util.ArrayList;
import java.util.Set;

import springfox.documentation.service.Tags;

public class ItemResponse {

	private String title;
	private String content;
	private int id;
	
	public ItemResponse(String title, String content, int id) {
		this.title = title;
		this.content = content;
		this.setId(id);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
