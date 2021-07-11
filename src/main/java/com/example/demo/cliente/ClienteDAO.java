package com.example.demo.cliente;

import com.example.demo.cliente.Cliente;

import org.springframework.data.repository.CrudRepository;

// Data Access Object
public interface ClienteDAO extends CrudRepository<Cliente, Long>  {
    
}
