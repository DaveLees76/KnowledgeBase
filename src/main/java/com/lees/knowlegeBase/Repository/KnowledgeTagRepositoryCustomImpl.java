package com.lees.knowlegeBase.Repository;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lees.knowlegeBase.entity.KnowledgeItem;
import com.lees.knowlegeBase.entity.KnowledgeTag;

@Transactional
public class KnowledgeTagRepositoryCustomImpl<T> implements KnowledgeTagRepositoryCustom<T> {
	
	
	
	public <S extends T> S save(S entity) {
					
		return null;
	}

}
