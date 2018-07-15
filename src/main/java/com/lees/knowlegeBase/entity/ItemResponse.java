package com.lees.knowlegeBase.entity;

import java.util.ArrayList;
import java.util.Set;


public class ItemResponse {

	private String title;
	private String content;
	private int id;
	private ArrayList<String> tags = new ArrayList<String>();
	
	public ItemResponse(String title, String content, int id, Set<Tag> tagSet) {
		this.title = title;
		this.content = content;
		this.setId(id);
		
		for(Tag t : tagSet) {
			tags.add(t.getTag());
		}
	}
	
	public ItemResponse() {
		this.title = "";
		this.content = "";
		this.id = -1;
		this.tags = new ArrayList<String>();
	}
	
	public void setValuesFromItem(Item item) {
		this.title = item.getTitle();
		this.content = item.getContent();
		this.id = item.getId();
		
		for(Tag t : item.getKnowledgeTags()) {
			tags.add(t.getTag());
		}
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

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}	
}
