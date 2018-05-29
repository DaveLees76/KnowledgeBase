package com.lees.knowlegeBase.repository;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lees.knowlegeBase.entity.Tag;
import com.lees.knowlegeBase.utility.MiscUtility;

@Component
public class MemoryCacheTagRepository {

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
		
		return tagCache.get(tag);
	}
}
