package com.example.demo.fachada;

import com.example.demo.cliente.IRepositorioCliente;
import com.example.demo.endereco.IRepositorioEndereco;
import com.example.demo.cliente.RepositorioClienteBDR;
import com.example.demo.endereco.RepositorioEnderecoBDR;
import com.example.demo.pagamento.IRepositorioPagamento;
import com.example.demo.pagamento.RepositorioPagamentoBDR;
import com.example.demo.pedido.IRepositorioPedido;
import com.example.demo.pedido.RepositorioPedidoBDR;
import com.example.demo.restaurante.IRepositorioRestaurante;
import com.example.demo.restaurante.RepositorioRestauranteBDR;
import com.example.demo.item.IRepositorioItem;
import com.example.demo.item.RepositorioItemBDR;

public class FabricaRepositorioBDR implements FabricaAbstrata {
    public FabricaRepositorioBDR() {

    }
    public IRepositorioCliente criarRepositorioCliente(){
        return new RepositorioClienteBDR();
    }
    public IRepositorioEndereco criarRepositorioEndereco(){
        return new RepositorioEnderecoBDR();
    }
    public IRepositorioRestaurante criarRepositorioRestaurante(){
        return new RepositorioRestauranteBDR();
    }
    public IRepositorioPedido criarRepositorioPedido(){
        return new RepositorioPedidoBDR();
    }
    public IRepositorioPagamento criarRepositorioPagamento(){
        return new RepositorioPagamentoBDR();
    }

    public IRepositorioItem criarRepositorioItem(){
        return new RepositorioItemBDR();
    }

}
