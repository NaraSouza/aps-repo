package com.example.demo.fachada;

import com.example.demo.avaliacao.IRepositorioAvaliacao;
import com.example.demo.cliente.IRepositorioCliente;
import com.example.demo.endereco.IRepositorioEndereco;
import com.example.demo.pedido.IRepositorioPedido;
import com.example.demo.restaurante.IRepositorioRestaurante;

public interface FabricaAbstrata {
    public IRepositorioCliente criarRepositorioCliente();
    public IRepositorioEndereco criarRepositorioEndereco();
    public IRepositorioPedido criarRepositorioPedido();
    public IRepositorioRestaurante criarRepositorioRestaurante();
    public IRepositorioAvaliacao criarRepositorioAvaliacao();
}
