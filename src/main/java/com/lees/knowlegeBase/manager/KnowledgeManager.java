package com.lees.knowlegeBase.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lees.knowlegeBase.adapter.KnowledgeRepositoryAdapter;
import com.lees.knowlegeBase.entity.Item;
import com.lees.knowlegeBase.entity.Tag;
import com.lees.knowlegeBase.repository.ItemRepository;
import com.lees.knowlegeBase.repository.MemoryCacheTagRepository;
import com.lees.knowlegeBase.repository.TagRepository;

@Component
public class KnowledgeManager {

	//@Autowired
	//KnowledgeRepositoryAdapter repositoryAdapter;
	
	private ItemRepository itemRepository;
	private TagRepository tagRepository;
	private MemoryCacheTagRepository tagCache;
	
	
	public KnowledgeManager(ItemRepository itemRepository, TagRepository tagRepository, MemoryCacheTagRepository tagCache) {
		
		this.itemRepository = itemRepository;
		this.tagRepository = tagRepository;
		this.tagCache = tagCache;
	}

	public boolean AddNewItemAndTags(String itemTitle, String itemContent, String tags) {
		
		Tag tagToSave = new Tag();
		String[] tagsList = tags.split(";");
		
		for(String tag : tagsList) {
		
			if (!tagCache.ContainsTag(tag)) {
			
				tagToSave = SaveTag(tag);
				tagCache.AddTag(tagToSave);				
			}
			else {
				tagToSave.setTag(tag);
				tagToSave.setId(tagCache.GetTagId(tag));
			}
			
			SaveItem(itemTitle, itemContent, tagToSave);
		}
		
		//itemRepository.save(itemToAdd);
		
		return true;
	}
	
	private Tag SaveTag(String tag) {
		
		Tag tagToSave = null;
		
		tagToSave = tagRepository.findByTag(tag);
		
		if (tagToSave == null) {
			tagToSave = new Tag();
			tagToSave.setTag(tag);
			tagRepository.save(tagToSave);
		}
		
		return tagToSave;
	}
	
	private Item SaveItem(String itemTitle, String itemContent, Tag associatedTag ) {
		
		Item itemToSave = new Item(itemTitle, itemContent);
		itemToSave.setTitle(itemTitle);
		itemToSave.setContent(itemContent);
		
		itemToSave.getKnowledgeTags().add(associatedTag);
		associatedTag.getKnowledgeItems().add(itemToSave);
		itemRepository.save(itemToSave);
		
		return itemToSave;
		
	}
}