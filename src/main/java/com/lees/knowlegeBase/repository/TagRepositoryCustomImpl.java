package com.lees.knowlegeBase.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.lees.knowlegeBase.entity.Tag;


@Transactional
public class TagRepositoryCustomImpl<T> implements TagRepositoryCustom<Tag> {
	
	@PersistenceContext
	EntityManager eManager;
	
	public <S extends Tag> S save(S tag) {
		
		Tag existingTag = null;
		
		Query customQuery = eManager.createNamedQuery("KnowledgeTag.findByTagInternal");
		customQuery.setParameter("tagString", tag.getTag());
		
		try {
			existingTag = (Tag)customQuery.getSingleResult();
		} catch (Exception e) {
			
		}
		
		if (existingTag == null) {
			eManager.persist(tag);
		}
		
		return null;
	}

}
