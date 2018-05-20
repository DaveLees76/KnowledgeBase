package com.lees.knowlegeBase.Repository;

import org.springframework.data.repository.CrudRepository;

import com.lees.knowlegeBase.entity.KnowledgeTag;

public interface KnowledgeTagRepository extends CrudRepository<KnowledgeTag, Integer>, KnowledgeTagRepositoryCustom<KnowledgeTag> {

	//KnowledgeTag findByTag(String tag);
	
}
