package com.lees.knowlegeBase.entity;

import javax.persistence.*;

@Entity
public class KnowledgeItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "KnowledgeItemTagId")
	private KnowledgeItemTag knowledgeItemTag;
	
	private String title;
	private String content;
	
	
	
	public KnowledgeItem() {
		
	}
	
	public KnowledgeItem(String title, String content, KnowledgeItemTag knowledgeItemTag) {
		this.title = title;
		this.content = content;
		this .knowledgeItemTag = knowledgeItemTag;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public KnowledgeItemTag getKnowledgeItemTag() {
		return knowledgeItemTag;
	}
	
	public void setKnowledgeItemTag(KnowledgeItemTag knowledgeItemTag) {
		this.knowledgeItemTag = knowledgeItemTag;
	}
}
