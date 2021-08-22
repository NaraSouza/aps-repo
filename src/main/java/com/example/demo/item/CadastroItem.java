package com.example.demo.item;

import org.springframework.stereotype.Component;

@Component
public class CadastroItem {

    private IRepositorioItem repositorioItem;

    public CadastroItem(IRepositorioItem repositorioItem){
        this.repositorioItem = repositorioItem;
    }

    public void inserir(Item item) {
        repositorioItem.inserir(item);
    }

    public void atualizar(Item item) {
        repositorioItem.atualizar(item);
    }

}
