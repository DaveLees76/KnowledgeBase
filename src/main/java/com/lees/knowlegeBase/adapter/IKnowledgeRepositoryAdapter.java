package com.lees.knowlegeBase.adapter;

import com.lees.knowlegeBase.repository.ItemRepository;
import com.lees.knowlegeBase.repository.TagRepository;

public interface IKnowledgeRepositoryAdapter {

	ItemRepository getItemRepository();
	TagRepository getTagRepository();
}
