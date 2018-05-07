package com.lees.knowlegeBase.Repository;

import org.springframework.data.repository.CrudRepository;

import com.lees.knowlegeBase.entity.KnowledgeItem;

public interface KnowledgeItemRepository extends CrudRepository<KnowledgeItem, Integer> {

}
