package com.lees.knowlegeBase.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.lees.knowlegeBase.repository.ItemRepository;
import com.lees.knowlegeBase.repository.TagRepository;

public class KnowledgeRepositoryAdapter implements IKnowledgeRepositoryAdapter{

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	TagRepository tagRepository;

	@Override
	public ItemRepository getItemRepository() {		
		return itemRepository;
	}

	@Override
	public TagRepository getTagRepository() {
		return tagRepository;
	}
	
	
}
