package com.lees.knowlegeBase.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.lees.knowlegeBase.entity.KnowledgeTag;


@Transactional
public class KnowledgeTagRepositoryCustomImpl<T> implements KnowledgeTagRepositoryCustom<KnowledgeTag> {
	
	@PersistenceContext
	EntityManager eManager;
	
	public <S extends KnowledgeTag> S save(S entity) {
		
		eManager.persist(entity);
		
		Query customQuery = eManager.createNamedQuery("KnowledgeTag.findByTag");
		
		customQuery.setParameter("tagString", entity.getTag());
		
		List<Object> resultList = customQuery.getResultList();
		
		KnowledgeTag foundTag = (KnowledgeTag)resultList.get(0);
		
		return null;
	}

}
