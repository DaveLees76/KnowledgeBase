package com.lees.knowlegeBase.repository;

import com.lees.knowlegeBase.entity.Tag;

public interface TagRepositoryCustom<T>  {
	
	<S extends T> S save(S entity);
	
	
}
