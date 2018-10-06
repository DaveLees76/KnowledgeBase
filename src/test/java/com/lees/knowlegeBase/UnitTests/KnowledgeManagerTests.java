package com.lees.knowlegeBase.UnitTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import org.apache.tomcat.util.bcel.Const;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.support.StaticApplicationContext;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import com.lees.knowlegeBase.repository.*;
import com.lees.knowlegeBase.entity.Item;
import com.lees.knowlegeBase.entity.ItemAndTags;
import com.lees.knowlegeBase.entity.Tag;
import com.lees.knowlegeBase.manager.KnowledgeManager;


public class KnowledgeManagerTests {

	private TagRepository mockTagRepository = mock(TagRepository.class);
	private ItemRepository mockItemRepository = mock(ItemRepository.class);
	private MemoryCacheTagRepository mockTagCache = mock(MemoryCacheTagRepository.class);
	private ArgumentCaptor<Tag> tagCaptor = ArgumentCaptor.forClass(Tag.class);
	private ArgumentCaptor<Item> itemCaptor = ArgumentCaptor.forClass(Item.class);
	private ArgumentCaptor<Tag> memcacheItemCaptor = ArgumentCaptor.forClass(Tag.class);
	
	@Test
	public void verifyAddItemAndTagsNewTags() {
		
		String  itemTitle = "Here is the item title";
		String itemContent = "Here is the item comtent";
		String tagsList = "tagOne,tagTwo";
		
		ItemAndTags itemAndTags = new ItemAndTags();
		itemAndTags.setItemTitle("Here is the item title");
		itemAndTags.setItemContent("Here is the item comtent");
		itemAndTags.setTags("tagOne,tagTwo");
		
		KnowledgeManager knowledgeManager= new KnowledgeManager(mockItemRepository, mockTagRepository, mockTagCache);
		knowledgeManager.AddNewItemAndTags(itemAndTags);
		
		verify(mockTagCache, times(2)).AddTag(memcacheItemCaptor.capture());
		List<Tag> savedMemcacheTags = memcacheItemCaptor.getAllValues();
		Tag memSavedTagOne = savedMemcacheTags.get(0);
		Tag memSavedTagTwo = savedMemcacheTags.get(0);
		
		verify(mockTagRepository, times(2)).save(tagCaptor.capture());
		List<Tag> savedTags = tagCaptor.getAllValues();
		Tag savedTagOne = savedTags.get(0);
		Tag savedTagTwo = savedTags.get(1);
		
		verify(mockItemRepository).save(itemCaptor.capture());
		Item savedItem = itemCaptor.getValue();
		
		assertEquals(memSavedTagOne.getTag(), "tagone");
		assertEquals(memSavedTagTwo.getTag(), "tagtwo");
		
		assertEquals(savedTagOne.getTag(), "tagone");
		assertEquals(savedTagOne.getKnowledgeItems().size(), 1);
		
		Item savedTagOneItem = savedTagOne.getKnowledgeItems().iterator().next();
		assertEquals(savedTagOneItem.getTitle(),   "Here is the item title");
		assertEquals(savedTagOneItem.getContent(), "Here is the item comtent");
		assertTrue(verifyItemContainsTag(savedTagOneItem, "tagone", 1));
		
		assertEquals(savedTagTwo.getTag(), "tagtwo");
		assertEquals(savedTagTwo.getKnowledgeItems().size(), 1);
		
		Item savedTagTwoItem = savedTagTwo.getKnowledgeItems().iterator().next();
		assertEquals(savedTagTwoItem.getTitle(),   "Here is the item title");
		assertEquals(savedTagTwoItem.getContent(), "Here is the item comtent");
		assertTrue(verifyItemContainsTag(savedTagTwoItem, "tagtwo", 1));
		
		assertEquals(savedItem.getTitle(), itemTitle);
		assertEquals(savedItem.getContent(), itemContent);
	}
	
	@Test
	public void verifyAddNewItemandTagsExistingTags(){
		
		String itemTitle = "Here is the item title";
		String itemContent = "Here is the item content";
		String taglist = "tagOne, tagTwo";
		
		ItemAndTags itemAndTags = new ItemAndTags();
		itemAndTags.setItemTitle(itemContent);
		itemAndTags.setItemContent(itemContent);
		itemAndTags.setTags(taglist);
	
		when(mockTagCache.ContainsTag("tagone")).thenReturn(true);
		when(mockTagCache.ContainsTag("tagtwo")).thenReturn(true);
		
		KnowledgeManager knowledgeManager = new KnowledgeManager(mockItemRepository, mockTagRepository, mockTagCache);
		knowledgeManager.AddNewItemAndTags(itemAndTags);
		
		verify(mockItemRepository).save(itemCaptor.capture());
		Item savedItem = itemCaptor.getValue();
		List<Tag> savedItemsTags = (List<Tag>)savedItem.getKnowledgeTags();
		Tag itemTagOne = savedItemsTags.get(0);
		Tag itemTagTwo = savedItemsTags.get(1);
		
		verify(mockTagCache, times(2)).AddTag(memcacheItemCaptor.capture());
		List<Tag> savedMemcacheTags = memcacheItemCaptor.getAllValues();
		Tag memSavedTagOne = savedMemcacheTags.get(0);
		Tag memSavedTagTwo = savedMemcacheTags.get(0);
		
		assertEquals(memSavedTagOne.getTag(), "tagone");
		assertEquals(memSavedTagTwo.getTag(), "tagtwo");
		
		assertEquals(savedItem.getTitle(), itemTitle);
		assertEquals(savedItem, itemContent);
		assertEquals(itemTagOne.getTag(), "tagone");
		assertEquals(itemTagTwo.getTag(), "tagtwo");
		
	}
	
	private boolean verifyItemContainsTag(Item itemToCheck, String tagValueToCheck, int expectedOccurrences)
	{
		int numTimesFound = 0;
		
		for(Tag tag : itemToCheck.getKnowledgeTags()) {
			if (tag.getTag().equalsIgnoreCase(tagValueToCheck))
					numTimesFound++;
		}
		
		return numTimesFound == expectedOccurrences;
	}
}
