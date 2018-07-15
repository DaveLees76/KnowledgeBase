package com.lees.knowlegeBase.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToMany
	@JoinTable (name = "item_tags", joinColumns = @JoinColumn(name = "KnowledgeItem_Id", referencedColumnName = "Id"), 
	inverseJoinColumns = @JoinColumn(name = "KnowledgeItem_Tag_Id", referencedColumnName = "Id"))
	private Set<Tag> knowledgeItemTags = new HashSet<Tag>();
	
	private String title;
	@Column(length=5000)
	private String content;
	
	
	
	public Item() {
		
	}
	
	public Item(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public Item(String title, String content, Set<Tag> knowledgeItemTags) {
		this.title = title;
		this.content = content;
		this.knowledgeItemTags = knowledgeItemTags;
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
	
	public Set<Tag> getKnowledgeTags() {
		return this.knowledgeItemTags;
	}
	
	public void setKnowledgeTags(Set<Tag> knowledgeItemTags) {
		this.knowledgeItemTags = knowledgeItemTags;
	}
}
