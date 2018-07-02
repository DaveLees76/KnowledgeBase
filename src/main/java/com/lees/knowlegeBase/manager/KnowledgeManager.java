package com.lees.knowlegeBase.manager;

import java.util.ArrayList;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lees.knowlegeBase.entity.Item;
import com.lees.knowlegeBase.entity.ItemAndTags;
import com.lees.knowlegeBase.entity.ItemResponse;
import com.lees.knowlegeBase.entity.Tag;
import com.lees.knowlegeBase.repository.IMemoryCacheTagRepository;
import com.lees.knowlegeBase.repository.ItemRepository;
import com.lees.knowlegeBase.repository.TagRepository;

@Component
public class KnowledgeManager implements IKnowledgeManager {

	private ItemRepository itemRepository;
	private TagRepository tagRepository;
	private IMemoryCacheTagRepository tagCache;
	
	@Autowired
	public KnowledgeManager(ItemRepository itemRepository, TagRepository tagRepository, IMemoryCacheTagRepository tagCache) {
		
		this.itemRepository = itemRepository;
		this.tagRepository = tagRepository;
		this.tagCache = tagCache;
	}

	public boolean AddNewItemAndTags(ItemAndTags newItemAndTags) {
		
		Tag tagToSave = new Tag();
		Item itemToSave = new Item();
		String[] tagsList = newItemAndTags.getTags().split(";");
		
		itemToSave.setTitle(newItemAndTags.getItemTitle());
		itemToSave.setContent(newItemAndTags.getItemContent());
		
		for(String tag : tagsList) {
		
			if (!tagCache.ContainsTag(tag)) {
			
				tagToSave = SaveTag(tag);
				tagCache.AddTag(tagToSave);				
			}
			else {
				tagToSave.setTag(tag);
				tagToSave.setId(tagCache.GetTagId(tag));
			}
						
			tagToSave.getKnowledgeItems().add(itemToSave);
			itemToSave.getKnowledgeTags().add(tagToSave);
		}
		
		itemRepository.save(itemToSave);
		
		return true;
	}
	
	public ArrayList<ItemResponse> getItemsByTag(String tag) {
		
		Tag foundTag = new Tag();
		ArrayList<ItemResponse> foundItems = new ArrayList<ItemResponse>();
		
		if (tagCache.ContainsTag(tag)) {
			foundTag = tagRepository.findById(tagCache.GetTagId(tag));
			
			for(Item i : foundTag.getKnowledgeItems()) {
				foundItems.add(new ItemResponse(i.getTitle(), i.getContent(), i.getId(), i.getKnowledgeTags()));
			}
		}
		
		return foundItems;
	}
	
	public ArrayList<String> getAllTags() {
		
		ArrayList<String> allTags = new ArrayList<String>();	
		Enumeration<String> tagEnumerator = tagCache.getAllTags();
		
		while (tagEnumerator.hasMoreElements()) {
			allTags.add((String)tagEnumerator.nextElement());
		}
		
		return allTags;
	}
	
	public Tag SaveTag(String tag) {
		
		Tag tagToSave = null;
		
		tagToSave = tagRepository.findByTag(tag);
		
		if (tagToSave == null) {
			tagToSave = new Tag();
			tagToSave.setTag(tag);
			tagRepository.save(tagToSave);
		}
		
		return tagToSave;
	}
	
	/*public Item SaveItem(String itemTitle, String itemContent, Tag associatedTag) {
		
		Item itemToSave = new Item(itemTitle, itemContent);
		itemToSave.setTitle(itemTitle);
		itemToSave.setContent(itemContent);
		
		itemToSave.getKnowledgeTags().add(associatedTag);
		associatedTag.getKnowledgeItems().add(itemToSave);
		itemRepository.save(itemToSave);
		
		return itemToSave;
		
	}*/
}
