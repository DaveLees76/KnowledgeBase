package com.lees.knowlegeBase.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lees.knowlegeBase.Repository.KnowledgeItemTagRepository;
import com.lees.knowlegeBase.entity.KnowledgeItem;
import com.lees.knowlegeBase.entity.KnowledgeItemTag;

@RestController
public class KnowledgeController {

	@Autowired
	KnowledgeItemTagRepository itemTagRepository;
	
	@RequestMapping(value = "/start")
	public String startPage() {
		
		KnowledgeItemTag tagA = new KnowledgeItemTag("Tag A");
		
		KnowledgeItem itemA1 = new KnowledgeItem("Title A1", "Content A1", tagA);
		KnowledgeItem itemA2 = new KnowledgeItem("Title A2", "Content A2", tagA);
		
		Set setA = new HashSet<KnowledgeItem>(){{
			add(itemA1);
			add(itemA2);
		}};
		
		tagA.setKnowledgeItem(setA);
		
		itemTagRepository.save(tagA);
		
		return "Success?";
	}
}
