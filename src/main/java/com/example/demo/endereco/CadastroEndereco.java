package com.example.demo.endereco;

import org.springframework.stereotype.Component;

@Component
public class CadastroEndereco {

    private IRepositorioEndereco repositorioEndereco;

    public CadastroEndereco(IRepositorioEndereco repositorioEndereco){
        this.repositorioEndereco = repositorioEndereco;
    }

    public void inserir(Endereco endereco) {
        repositorioEndereco.inserir(endereco);
    }

}
