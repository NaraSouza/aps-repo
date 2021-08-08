package com.example.demo.pedido;

import org.springframework.data.repository.CrudRepository;

// Data Access Object
public interface PedidoDAO extends CrudRepository<Pedido, Long>  {

}
