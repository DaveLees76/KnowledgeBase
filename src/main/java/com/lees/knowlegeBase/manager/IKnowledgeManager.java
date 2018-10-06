package com.lees.knowlegeBase.manager;

import java.util.ArrayList;
import com.lees.knowlegeBase.entity.ItemAndTags;
import com.lees.knowlegeBase.entity.ItemResponse;
import com.lees.knowlegeBase.entity.Tag;

public interface IKnowledgeManager {
	
	boolean AddNewItemAndTags(ItemAndTags newItemAndTags);
	
	ArrayList<ItemResponse> getItemsByTag(String tag);
	
	Tag saveTag(String tag);
	
	ItemResponse getItemById(int id);
}
