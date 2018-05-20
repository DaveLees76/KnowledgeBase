package com.lees.knowlegeBase.Repository;

import com.lees.knowlegeBase.entity.KnowledgeTag;

public interface KnowledgeTagRepositoryCustom<T>  {
	
	<S extends T> S save(S entity);
	
}
