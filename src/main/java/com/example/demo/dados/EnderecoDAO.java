package com.example.demo.dados;

import com.example.demo.negocio.Cliente;

import com.example.demo.negocio.Endereco;
import org.springframework.data.repository.CrudRepository;

// Data Access Object
public interface EnderecoDAO extends CrudRepository<Endereco, Long>  {

}
