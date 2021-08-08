package com.example.demo.controllers;

import java.util.Random;

import com.example.demo.pagamento.CadastroPagamento;
import com.example.demo.pagamento.IRepositorioPagamento;
import com.example.demo.pagamento.Pagamento;
import com.example.demo.pedido.CadastroPedido;
import com.example.demo.pedido.IRepositorioPedido;
import com.example.demo.pedido.Item;
import com.example.demo.pedido.Pedido;
import com.example.demo.restaurante.CadastroRestaurante;
import com.example.demo.restaurante.FilaPedidos;
import com.example.demo.restaurante.IRepositorioRestaurante;
import com.example.demo.restaurante.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class ControladorEfetuarPedido {

    private CadastroPedido cadastroPedido;
    private CadastroRestaurante cadastroRestaurante;
    private CadastroPagamento cadastroPagamento;

    public ControladorEfetuarPedido(IRepositorioRestaurante repositorioRestaurante, IRepositorioPedido repositorioPedido, IRepositorioPagamento repositorioPagamento){
        this.cadastroPedido = new CadastroPedido(repositorioPedido);
        this.cadastroRestaurante = new CadastroRestaurante(repositorioRestaurante);
        this.cadastroPagamento = new CadastroPagamento(repositorioPagamento);
    }

    public void inserirCarrinho(Pedido pedido) {
        cadastroPedido.inserir(pedido);
    }

    public void inserirRestaurante(Restaurante restaurante) {
        cadastroRestaurante.inserir(restaurante);
    }

    public void fazerPagamento(Pagamento pagamento, Restaurante restaurante, Pedido pedido) {
        Random random = new Random();

        //simulando requisicao de validacao de pagamento à operadora de cartao
        try {
            Thread.sleep(2000);
        } 
        catch(InterruptedException e) {
            System.out.println("Erro na requisicao");
        }

        //simulando resposta da operadora de cartao
        if(!random.nextBoolean()) {
            System.out.println("Falha no pagamento");
        } else {
            cadastroPedido.inserir(pedido);
            FilaPedidos filaPedidos = new FilaPedidos(pedido);
            restaurante.setFilaPedidos(filaPedidos);
            cadastroRestaurante.atualizar(restaurante);
            cadastroPagamento.inserir(pagamento);
        }
    }
}
