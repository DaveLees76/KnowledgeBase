package com.lees.knowlegeBase.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lees.knowlegeBase.entity.Item;
import com.lees.knowlegeBase.entity.Tag;
import com.lees.knowlegeBase.repository.ItemRepository;
import com.lees.knowlegeBase.repository.TagRepository;

@Component
public  class MiscUtility {
	
	private ItemRepository itemRepository;
	
	private TagRepository tagRepository;
	
	@Autowired
	public MiscUtility(ItemRepository itemRepository, TagRepository tagRepository) {
		
		this.itemRepository = itemRepository;
		this.tagRepository = tagRepository;
	}
	
	public void SeedDatabase() {
		
		Tag tagA = new Tag("Tag A");
		Tag tagB = new Tag("Tag B");
		Tag tagC = new Tag("Tag C");
		
		Item itemA = new Item("Title A1", "Content A1");
		Item itemB = new Item("Title A2", "Content A2");
		
		tagRepository.save(tagA);
		tagRepository.save(tagB);
		tagRepository.save(tagC);
		
		itemA.getKnowledgeTags().add(tagA);
		itemA.getKnowledgeTags().add(tagC);
		
		itemB.getKnowledgeTags().add(tagA);
		itemB.getKnowledgeTags().add(tagB);
		
		tagA.getKnowledgeItems().add(itemA);
		tagA.getKnowledgeItems().add(itemB);
		
		tagC.getKnowledgeItems().add(itemA);
		tagB.getKnowledgeItems().add(itemB);
		
		itemRepository.save(itemA);
		itemRepository.save(itemB);
	}
}
