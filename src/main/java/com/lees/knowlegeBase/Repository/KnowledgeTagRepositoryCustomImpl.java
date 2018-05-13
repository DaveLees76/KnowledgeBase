package com.lees.knowlegeBase.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public class KnowledgeTagRepositoryCustomImpl<T> implements KnowledgeTagRepositoryCustom<T> {
	
	@PersistenceContext
	EntityManager eManager;
	
	public <S extends T> S save(S entity) {
			
		eManager.persist(entity);
		
		return null;
	}

}
