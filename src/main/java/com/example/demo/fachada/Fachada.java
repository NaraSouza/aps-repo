package com.example.demo.fachada;

import com.example.demo.cliente.Cliente;
import com.example.demo.controllersM.ControladorAvaliarPedido;
import com.example.demo.controllersM.ControladorCadastroCliente;
import com.example.demo.endereco.Endereco;
import com.example.demo.pedido.Pedido;
import com.example.demo.avaliacao.Avaliacao;
import com.example.demo.restaurante.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class Fachada {

    private FabricaAbstrata fabricaAbstrata;
    private ControladorCadastroCliente controladorCadastroCliente;
    private ControladorAvaliarPedido controladorAvaliarPedido;

    public Fachada() {
        this.fabricaAbstrata = new FabricaRepositorioBDR();
        this.controladorCadastroCliente = new ControladorCadastroCliente(fabricaAbstrata.criarRepositorioCliente(), fabricaAbstrata.criarRepositorioEndereco());
        this.controladorAvaliarPedido = new ControladorAvaliarPedido(fabricaAbstrata.criarRepositorioCliente(), fabricaAbstrata.criarRepositorioPedido(), fabricaAbstrata.criarRepositorioRestaurante(), fabricaAbstrata.criarRepositorioAvaliacao());
    }

    public void cadastrar(Cliente cliente, Endereco endereco){
        controladorCadastroCliente.inserirEndereco(endereco);
        controladorCadastroCliente.inserirCliente(cliente);
    }

    public void avaliarPedido(Pedido pedido, Restaurante restaurante, Avaliacao avaliacao){
        controladorAvaliarPedido.inserirPedido(pedido);
        controladorAvaliarPedido.inserirRestaurante(restaurante);
        controladorAvaliarPedido.inserirAvaliacao(avaliacao);
        controladorAvaliarPedido.validarAvaliacao(pedido, restaurante, avaliacao);
    }

}