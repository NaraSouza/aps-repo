package com.example.demo.avaliacao;

import org.springframework.stereotype.Component;

@Component
public class CadastroAvaliacao {

    private IRepositorioAvaliacao repositorioAvaliacao;

    public CadastroAvaliacao(IRepositorioAvaliacao repositorioPedido){
        this.repositorioAvaliacao = repositorioPedido;
    }

    public void inserir(Avaliacao avaliacao) {
        repositorioAvaliacao.inserir(avaliacao);
    }

}
