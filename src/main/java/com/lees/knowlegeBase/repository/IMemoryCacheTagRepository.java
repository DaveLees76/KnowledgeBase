package com.lees.knowlegeBase.repository;

import java.util.Enumeration;

import com.lees.knowlegeBase.entity.Tag;

public interface IMemoryCacheTagRepository {

	void AddTag(Tag tagToAdd);

	void RemoveTag(Tag tagToRemove);

	boolean ContainsTag(String tagValue);

	int GetTagId(String tag);

	Enumeration<String> getAllTags();
}
