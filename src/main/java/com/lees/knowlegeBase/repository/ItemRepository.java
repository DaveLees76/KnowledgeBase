package com.lees.knowlegeBase.repository;

import org.springframework.data.repository.CrudRepository;

import com.lees.knowlegeBase.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
