package com.lees.knowlegeBase.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;



@Entity
@Table( name="knowledge_tag")
@NamedQuery(name = "KnowledgeTag.findByTagInternal",
query = "select t from Tag t where t.tag = :tagString")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tag;
	
	@ManyToMany(mappedBy="knowledgeItemTags", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Item> knowledgeItems = new HashSet<Item>();
	
	public Tag() {
		
	}
		
	public Tag(String tag) {
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
		
	public Set<Item> getKnowledgeItems() {
		return knowledgeItems;
	}
	
	public void setKnowledgeItems(Set<Item> knowledgeItems) {
		this.knowledgeItems = knowledgeItems;
	}
	
}
