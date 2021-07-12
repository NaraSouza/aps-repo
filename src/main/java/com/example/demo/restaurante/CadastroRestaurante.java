package com.example.demo.restaurante;

import org.springframework.stereotype.Component;

@Component
public class CadastroRestaurante {

    private IRepositorioRestaurante repositorioRestaurante;

    public CadastroRestaurante(IRepositorioRestaurante repositorioRestaurante){
        this.repositorioRestaurante = repositorioRestaurante;
    }

    public void inserir(Restaurante restaurante) {
        repositorioRestaurante.inserir(restaurante);
    }

    public void atualizar(Restaurante restaurante) {
        repositorioRestaurante.atualizar(restaurante);
    }


}
