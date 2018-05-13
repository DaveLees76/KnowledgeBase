package com.lees.knowlegeBase.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class KnowledgeItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToMany
	@JoinTable (name = "Knowledge_KnowledgeItem", joinColumns = @JoinColumn(name = "KnowledgeItem_Id", referencedColumnName = "Id"), 
	inverseJoinColumns = @JoinColumn(name = "KnowledgeItem_Tag_Id", referencedColumnName = "Id"))
	private Set<KnowledgeTag> knowledgeItemTags = new HashSet<KnowledgeTag>();
	
	private String title;
	private String content;
	
	
	
	public KnowledgeItem() {
		
	}
	
	public KnowledgeItem(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public KnowledgeItem(String title, String content, Set<KnowledgeTag> knowledgeItemTags) {
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
	
	public Set<KnowledgeTag> getKnowledgeTags() {
		return this.knowledgeItemTags;
	}
	
	public void setKnowledgeTags(Set<KnowledgeTag> knowledgeItemTags) {
		this.knowledgeItemTags = knowledgeItemTags;
	}
}
