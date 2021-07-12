package com.example.demo.cliente;

import com.example.demo.ApplicationContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioClienteBDR implements IRepositorioCliente {

    @Autowired
    private ClienteDAO clienteDAO;

    public RepositorioClienteBDR(){
        this.clienteDAO = ApplicationContextHolder.getContext().getBean(ClienteDAO.class);
    }

    @Override
    public void inserir(Cliente cliente) {
        clienteDAO.save(cliente);
        
    }

    @Override
    public Iterable<Cliente> getAll() {
        return clienteDAO.findAll();
    }
    
}
