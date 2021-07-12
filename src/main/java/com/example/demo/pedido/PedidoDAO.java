package com.example.demo.pedido;

import com.example.demo.endereco.Endereco;
import org.springframework.data.repository.CrudRepository;

// Data Access Object
public interface PedidoDAO extends CrudRepository<Pedido, Long>  {

}
