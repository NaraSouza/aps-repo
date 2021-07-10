package com.example.demo.dados;

import com.example.demo.negocio.Cliente;

import com.example.demo.negocio.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioEnderecoBDR implements IRepositorioEndereco{

    @Autowired
    private EnderecoDAO enderecoDAO;

    @Override
    public void inserir(Endereco endereco) {
        enderecoDAO.save(endereco);

    }

    @Override
    public Iterable<Endereco> getAll() {
        return enderecoDAO.findAll();
    }
}
