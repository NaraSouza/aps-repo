package com.example.demo.restaurante;

import org.springframework.data.repository.CrudRepository;

// Data Access Object
public interface RestauranteDAO extends CrudRepository<Restaurante, Long>  {

}
