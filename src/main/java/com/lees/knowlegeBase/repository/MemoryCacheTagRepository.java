package com.lees.knowlegeBase.repository;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lees.knowlegeBase.entity.Tag;
import com.lees.knowlegeBase.utility.MiscUtility;

import antlr.collections.Enumerator;

@Component
public class MemoryCacheTagRepository implements IMemoryCacheTagRepository {

	Hashtable<String, Integer> tagCache = new Hashtable<>();
	
	@Autowired
	public MemoryCacheTagRepository(TagRepository tagRepository, MiscUtility miscUtility) {
		
		miscUtility.SeedDatabase();
		List<Tag> tagList = (List<Tag>)tagRepository.findAll();
		
		for (Tag tag : tagList) {
			
			tagCache.put(tag.getTag(), tag.getId());
		}
	}
	
	public void AddTag(Tag tagToAdd) {
		
		tagCache.put(tagToAdd.getTag(), tagToAdd.getId());
	}
	
	public void RemoveTag(Tag tagToRemove) {
		
		tagCache.remove(tagToRemove.getTag());
	}
	
	public boolean ContainsTag(String tagValue) {
		
		return tagCache.containsKey(tagValue);
	}
	
	public int GetTagId (String tag) {
		
		int id = 0;
		
		try {
		
			id = tagCache.get(tag);
		}
		catch(NullPointerException e) {
			
		}
		
		return id;
	}
	
	public Enumeration<String> getAllTags() {
		return tagCache.keys();
	}
}
