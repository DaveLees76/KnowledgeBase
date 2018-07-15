package com.lees.knowlegeBase.controller;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lees.knowlegeBase.entity.ItemAndTags;
import com.lees.knowlegeBase.entity.ItemResponse;
import com.lees.knowlegeBase.manager.IKnowledgeManager;



@RestController
public class KnowledgeController {

	@Autowired
	IKnowledgeManager knowledgeManager;
	
	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public ResponseEntity<String> addItemPost(@RequestBody ItemAndTags newItemAndTags) {
		
		knowledgeManager.AddNewItemAndTags(newItemAndTags);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/getitemsbytag", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<ItemResponse> getItemsByTag(String tag) {

		return knowledgeManager.getItemsByTag(tag);
	}
	
	@RequestMapping(value = "/getitembyid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemResponse getItemById(int id) {
		
		return knowledgeManager.getItemById(id);
	}
}
