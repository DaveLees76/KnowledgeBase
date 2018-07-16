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
		
		Tag tagA = new Tag("passwords");
		Tag tagB = new Tag("servers");
		//Tag tagC = new Tag("Tag C");
		
		Item itemA = new Item("Password for Database", "Here is the database password");
		Item itemB = new Item("Password for the Server", "Here is the password for the server");
		
		tagRepository.save(tagA);
		tagRepository.save(tagB);
		//tagRepository.save(tagC);
		
		itemA.getKnowledgeTags().add(tagA);
		itemA.getKnowledgeTags().add(tagB);
		
		itemB.getKnowledgeTags().add(tagA);
		itemB.getKnowledgeTags().add(tagB);
		
		tagA.getKnowledgeItems().add(itemA);
		tagA.getKnowledgeItems().add(itemB);
		
		tagB.getKnowledgeItems().add(itemA);
		tagB.getKnowledgeItems().add(itemB);
		
		itemRepository.save(itemA);
		itemRepository.save(itemB);
	}
}
