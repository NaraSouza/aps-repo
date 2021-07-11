package com.example.demo.pedido;

import org.springframework.stereotype.Component;

@Component
public class CadastroPedido {

    private IRepositorioPedido repositorioPedido;

    public CadastroPedido(IRepositorioPedido repositorioPedido){
        this.repositorioPedido = repositorioPedido;
    }

    public void inserir(Pedido pedido) {
        repositorioPedido.inserir(pedido);
    }

    public void atualizar(Pedido pedido) {
        repositorioPedido.atualizar(pedido);
    }

}
