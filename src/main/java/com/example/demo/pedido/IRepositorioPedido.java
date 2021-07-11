package com.example.demo.pedido;

import com.example.demo.pedido.Pedido;

public interface IRepositorioPedido {

    public void inserir(Pedido pedido);

    public void atualizar(Pedido pedido);

    public Iterable<Pedido> getAll();

}
