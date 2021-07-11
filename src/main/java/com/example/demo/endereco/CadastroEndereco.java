package com.example.demo.negocio;

import com.example.demo.dados.IRepositorioEndereco;
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
