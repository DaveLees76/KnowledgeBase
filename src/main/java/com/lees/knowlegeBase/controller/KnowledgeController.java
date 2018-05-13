package com.lees.knowlegeBase.controller;


import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lees.knowlegeBase.Repository.KnowledgeItemRepository;
import com.lees.knowlegeBase.Repository.KnowledgeTagRepository;
import com.lees.knowlegeBase.entity.KnowledgeItem;
import com.lees.knowlegeBase.entity.KnowledgeTag;

import antlr.collections.List;

@RestController
public class KnowledgeController {

	@Autowired
	KnowledgeItemRepository itemRepository;
	
	@Autowired 
	KnowledgeTagRepository tagRepository;
	
	@RequestMapping(value = "/start")
	public String startPage() {
		
		KnowledgeTag tagA = new KnowledgeTag("Tag A");
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
		itemRepository.save(itemB);
		
		return "Success?";
	}
	
	@RequestMapping(value = "/additem")
	public String addItem(@RequestParam String itemTitle, @RequestParam String itemContent, @RequestParam String tags) {
		
		//StringTokenizer tokenTags = new StringTokenizer(tags, ";");
		String[] tagsList = tags.split(";");
		KnowledgeItem itemToAdd = new KnowledgeItem(itemTitle, itemContent);
		
		
		for(String tag : tagsList) {
			KnowledgeTag tagToAdd = new KnowledgeTag();
			tagToAdd.setTag(tag);
			tagRepository.save(tagToAdd);
			
			tagToAdd.getKnowledgeItems().add(itemToAdd);
			itemToAdd.getKnowledgeTags().add(tagToAdd);
			
			itemRepository.save(itemToAdd);
		}
		
		itemRepository.save(itemToAdd);
		
		return "Success!";
	}
}
