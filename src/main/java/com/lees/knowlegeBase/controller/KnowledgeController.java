package com.lees.knowlegeBase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lees.knowlegeBase.manager.IKnowledgeManager;



@RestController
public class KnowledgeController {

	@Autowired
	IKnowledgeManager knowledgeManager;
	
	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public String addItem(@RequestParam String itemTitle, @RequestParam String itemContent, @RequestParam String tagList) {
		
		knowledgeManager.AddNewItemAndTags(itemTitle, itemContent, tagList);
		
		return "Success!";
	}
}
