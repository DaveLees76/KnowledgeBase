package com.lees.knowlegeBase.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class KnowledgeItemTag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tag;
	
	@OneToMany(mappedBy="knowledgeItemTag", cascade = CascadeType.ALL)
	private Set<KnowledgeItem> knowledgeItems;
	
	public KnowledgeItemTag() {
		
	}
		
	public KnowledgeItemTag(String tag) {
		this.tag = tag;
		this.knowledgeItems = knowledgeItems;
	}
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
		
	public Set<KnowledgeItem> getKnowledgeItem() {
		return knowledgeItems;
	}
	
	public void setKnowledgeItem(Set<KnowledgeItem> knowledgeItems) {
		this.knowledgeItems = knowledgeItems;
	}
	
}
