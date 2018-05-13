package com.lees.knowlegeBase.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToMany;



@Entity
@Table( name="knowledge_tag")
public class KnowledgeTag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tag;
	
	@ManyToMany(mappedBy="knowledgeItemTags", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<KnowledgeItem> knowledgeItems = new HashSet<KnowledgeItem>();
	
	public KnowledgeTag() {
		
	}
		
	public KnowledgeTag(String tag) {
		this.tag = tag;
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
		
	public Set<KnowledgeItem> getKnowledgeItems() {
		return knowledgeItems;
	}
	
	public void setKnowledgeItems(Set<KnowledgeItem> knowledgeItems) {
		this.knowledgeItems = knowledgeItems;
	}
	
}
