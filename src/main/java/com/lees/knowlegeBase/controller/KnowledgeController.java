package com.lees.knowlegeBase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lees.knowlegeBase.entity.Item;
import com.lees.knowlegeBase.entity.Tag;
import com.lees.knowlegeBase.manager.KnowledgeManager;
import com.lees.knowlegeBase.repository.ItemRepository;
import com.lees.knowlegeBase.repository.TagRepository;


@RestController
public class KnowledgeController {

	@Autowired
	KnowledgeManager knowledgeManager;
	
	@RequestMapping(value = "/start")
	public String startPage() {
		
		/*KnowledgeTag tagA = new KnowledgeTag("Tag A");
		KnowledgeTag tagB = new KnowledgeTag("Tag B");
		KnowledgeTag tagC = new KnowledgeTag("Tag C");
		
		KnowledgeItem itemA = new KnowledgeItem("Title A1", "Content A1");
		KnowledgeItem itemB = new KnowledgeItem("Title A2", "Content A2");
		
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
		itemRepository.save(itemB); */
		
		return "Success?";
	}
	
	@RequestMapping(value = "/additem")
	public String addItem(@RequestParam String itemTitle, @RequestParam String itemContent, @RequestParam String tagList) {
		
		/*String[] tagsList = tags.split(";");
		KnowledgeItem itemToAdd = new KnowledgeItem(itemTitle, itemContent);
		
		
		for(String tag : tagsList) {
			KnowledgeTag tagToAdd = new KnowledgeTag();
			tagToAdd.setTag(tag);
			tagRepository.save(tagToAdd);
			
			tagToAdd.getKnowledgeItems().add(itemToAdd);
			itemToAdd.getKnowledgeTags().add(tagToAdd);
			
			itemRepository.save(itemToAdd);
		}
		
		itemRepository.save(itemToAdd); */
		
		knowledgeManager.AddNewItemAndTags(itemTitle, itemContent, tagList);
		
		return "Success!";
	}
}
