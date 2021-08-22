package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.item.Item;
import com.example.demo.item.CadastroItem;
import com.example.demo.item.IRepositorioItem;
import com.example.demo.pagamento.CadastroPagamento;
import com.example.demo.pagamento.IRepositorioPagamento;
import com.example.demo.pagamento.Pagamento;
import com.example.demo.pedido.CadastroPedido;
import com.example.demo.pedido.IRepositorioPedido;
import com.example.demo.pedido.Pedido;
import com.example.demo.restaurante.CadastroRestaurante;
import com.example.demo.restaurante.IRepositorioRestaurante;
import com.example.demo.restaurante.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class ControladorEfetuarPedido {

    private CadastroPedido cadastroPedido;
    private CadastroRestaurante cadastroRestaurante;
    private CadastroPagamento cadastroPagamento;
    private CadastroItem cadastroItem;

    public ControladorEfetuarPedido(IRepositorioRestaurante repositorioRestaurante, IRepositorioPedido repositorioPedido, IRepositorioPagamento repositorioPagamento, IRepositorioItem repositorioItem){
        this.cadastroPedido = new CadastroPedido(repositorioPedido);
        this.cadastroRestaurante = new CadastroRestaurante(repositorioRestaurante);
        this.cadastroPagamento = new CadastroPagamento(repositorioPagamento);
        this.cadastroItem = new CadastroItem(repositorioItem);
    }

    public void inserirItens(List<Item> itens) {
        for(Item item : itens) {
            cadastroItem.inserir(item);
        }
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
            List<Pedido> filaPedidos = new ArrayList<Pedido>();
            filaPedidos.add(pedido);
            restaurante.setFilaPedidos(filaPedidos);
            cadastroRestaurante.atualizar(restaurante);
            cadastroPagamento.inserir(pagamento);
        }
    }
}
