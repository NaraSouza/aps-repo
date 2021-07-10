package com.example.demo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fachada {

    private FabricaAbstrata fabricaAbstrata;
    private ControladorCadastroCliente controladorCadastroCliente;

    public Fachada() {
        this.fabricaAbstrata = new FabricaRepositorioBDR();
        this.controladorCadastroCliente = new ControladorCadastroCliente(fabricaAbstrata.criarRepositorioCliente(), fabricaAbstrata.criarRepositorioEndereco());
    }

    public void inserirCliente(Cliente cliente) {
        controladorCadastroCliente.inserirCliente(cliente);
    }

    public void inserirEndereco(Endereco endereco) {
        controladorCadastroCliente.inserirEndereco(endereco);
    }

}