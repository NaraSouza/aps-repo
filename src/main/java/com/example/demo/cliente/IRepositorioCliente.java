package com.example.demo.cliente;

import com.example.demo.cliente.Cliente;

public interface IRepositorioCliente {


    public void inserir(Cliente cliente);

    public Iterable<Cliente> getAll();
    
}
