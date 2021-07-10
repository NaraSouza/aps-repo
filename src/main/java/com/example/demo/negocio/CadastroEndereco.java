package com.example.demo.negocio;

import com.example.demo.dados.IRepositorioCliente;

import com.example.demo.dados.IRepositorioEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroEndereco {

    @Autowired
    private IRepositorioEndereco repositorioEndereco;

    public void inserir(Endereco endereco) {
        repositorioEndereco.inserir(endereco);
    }

}
