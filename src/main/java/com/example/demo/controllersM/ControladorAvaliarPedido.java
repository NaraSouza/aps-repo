package com.example.demo.controllersM;

import com.example.demo.avaliacao.CadastroAvaliacao;
import com.example.demo.avaliacao.IRepositorioAvaliacao;
import com.example.demo.cliente.IRepositorioCliente;
import com.example.demo.cliente.CadastroCliente;
import com.example.demo.cliente.Cliente;
import com.example.demo.pedido.CadastroPedido;
import com.example.demo.pedido.IRepositorioPedido;
import com.example.demo.pedido.Pedido;
import com.example.demo.avaliacao.Avaliacao;
import com.example.demo.restaurante.CadastroRestaurante;
import com.example.demo.restaurante.IRepositorioRestaurante;
import com.example.demo.restaurante.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class ControladorAvaliarPedido {

    private CadastroCliente cadastroCliente;
    private CadastroPedido cadastroPedido;
    private CadastroRestaurante cadastroRestaurante;
    private CadastroAvaliacao cadastroAvaliacao;

    public ControladorAvaliarPedido(IRepositorioCliente repositorioCliente, IRepositorioPedido repositorioPedido, IRepositorioRestaurante repositorioRestaurante, IRepositorioAvaliacao repositorioAvaliacao){
        this.cadastroCliente = new CadastroCliente(repositorioCliente);
        this.cadastroPedido = new CadastroPedido(repositorioPedido);
        this.cadastroRestaurante = new CadastroRestaurante(repositorioRestaurante);
        this.cadastroAvaliacao = new CadastroAvaliacao(repositorioAvaliacao);
    }

    public void inserirCliente(Cliente cliente) {
        cadastroCliente.inserir(cliente);
    }

    public void inserirPedido(Pedido pedido) {
        cadastroPedido.inserir(pedido);
    }

    public void inserirRestaurante(Restaurante restaurante) {
        cadastroRestaurante.inserir(restaurante);
    }

    public void inserirAvaliacao(Avaliacao avaliacao) {
        cadastroAvaliacao.inserir(avaliacao);
    }

    public Iterable<Cliente> getAll() {
        return cadastroCliente.getAll();
    }

    public void validarAvaliacao(Pedido pedido, Restaurante restaurante, Avaliacao avaliacao){
        if(avaliacao.getComentario().equals("") || avaliacao.getNota() == 0){
            System.out.println("Erro na avaliacao");
        } else {
            pedido.setAvaliacao(avaliacao);
            restaurante.addAvaliacao(avaliacao);
            cadastroRestaurante.atualizar(restaurante);
            cadastroPedido.atualizar(pedido);
        }
    }
}
