package com.example.demo.cliente;

import org.springframework.stereotype.Component;

@Component
public class CadastroCliente {
    
    private IRepositorioCliente repositorioCliente;

    public CadastroCliente(IRepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public void inserir(Cliente cliente) {
        repositorioCliente.inserir(cliente);
    }

    public Iterable<Cliente> getAll() {
        return repositorioCliente.getAll();
    }
    
}
