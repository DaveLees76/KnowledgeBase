package com.lees.knowlegeBase.repository;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.repository.CrudRepository;
import com.lees.knowlegeBase.entity.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer>, TagRepositoryCustom<Tag> {

	Tag findByTag(String tag);
	
}
