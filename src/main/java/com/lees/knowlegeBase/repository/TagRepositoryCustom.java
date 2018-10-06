package com.lees.knowlegeBase.repository;

public interface TagRepositoryCustom<T>  {
	
	<S extends T> S save(S entity);
	
	
}
