package com.lees.knowlegeBase.manager;

import com.lees.knowlegeBase.entity.Item;
import com.lees.knowlegeBase.entity.Tag;

public interface IKnowledgeManager {
	
	boolean AddNewItemAndTags(String itemTitle, String itemContent, String tags);
	
	Tag SaveTag(String tag);
	
	Item SaveItem(String itemTitle, String itemContent, Tag associatedTag);
}
