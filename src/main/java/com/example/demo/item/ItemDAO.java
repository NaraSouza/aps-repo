package com.example.demo.item;

import org.springframework.data.repository.CrudRepository;

// Data Access Object
public interface ItemDAO extends CrudRepository<Item, Long>  {

}
