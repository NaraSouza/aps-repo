package com.example.demo.dados;

import com.example.demo.ApplicationContextHolder;

import com.example.demo.endereco.Endereco;
import org.springframework.stereotype.Component;

@Component
public class RepositorioEnderecoBDR implements IRepositorioEndereco{

    private EnderecoDAO enderecoDAO;

    public RepositorioEnderecoBDR(){
        this.enderecoDAO = ApplicationContextHolder.getContext().getBean(EnderecoDAO.class);
    }

    @Override
    public void inserir(Endereco endereco) {
        enderecoDAO.save(endereco);

    }

    @Override
    public Iterable<Endereco> getAll() {
        return enderecoDAO.findAll();
    }
}
