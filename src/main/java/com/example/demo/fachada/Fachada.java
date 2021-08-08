package com.example.demo.fachada;

import com.example.demo.cliente.Cliente;
import com.example.demo.controllers.ControladorCadastroCliente;
import com.example.demo.controllers.ControladorEfetuarPedido;
import com.example.demo.endereco.Endereco;
import com.example.demo.pagamento.Pagamento;
import com.example.demo.pedido.Pedido;
import com.example.demo.restaurante.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class Fachada {

    private FabricaAbstrata fabricaAbstrata;
    private ControladorCadastroCliente controladorCadastroCliente;
    private ControladorEfetuarPedido controladorEfetuarPedido;

    public Fachada() {
        this.fabricaAbstrata = new FabricaRepositorioBDR();
        this.controladorCadastroCliente = new ControladorCadastroCliente(fabricaAbstrata.criarRepositorioCliente(), fabricaAbstrata.criarRepositorioEndereco());
        this.controladorEfetuarPedido = new ControladorEfetuarPedido(fabricaAbstrata.criarRepositorioRestaurante(), fabricaAbstrata.criarRepositorioPedido(), fabricaAbstrata.criarRepositorioPagamento());
    }

    public void cadastrar(Cliente cliente, Endereco endereco){
        controladorCadastroCliente.inserirEndereco(endereco);
        controladorCadastroCliente.inserirCliente(cliente);
    }

    public void efetuarPedido(Pedido pedido, Restaurante restaurante, Pagamento pagamento){
        controladorEfetuarPedido.inserirRestaurante(restaurante);
        controladorEfetuarPedido.inserirCarrinho(pedido);
        controladorEfetuarPedido.fazerPagamento(pagamento, restaurante, pedido);
    }

}