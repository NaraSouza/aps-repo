package com.example.demo.endereco;

import com.example.demo.endereco.Endereco;
import org.springframework.data.repository.CrudRepository;

// Data Access Object
public interface EnderecoDAO extends CrudRepository<Endereco, Long>  {

}
