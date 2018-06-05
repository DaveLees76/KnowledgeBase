package com.lees.knowlegeBase.manager;

import java.util.ArrayList;
import java.util.HashSet;

import com.lees.knowlegeBase.entity.Item;
import com.lees.knowlegeBase.entity.ItemAndTags;
import com.lees.knowlegeBase.entity.ItemResponse;
import com.lees.knowlegeBase.entity.Tag;
import com.mysql.fabric.xmlrpc.base.Array;

public interface IKnowledgeManager {
	
	boolean AddNewItemAndTags(ItemAndTags newItemAndTags);
	
	ArrayList<ItemResponse> getItemsByTag(String tag);
	
	Tag SaveTag(String tag);
	
	Item SaveItem(String itemTitle, String itemContent, Tag associatedTag);
}
