package com.example.demo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fachada {

    @Autowired
    private ControladorCadastroCliente controladorCadastroCliente;

    public void inserirCliente(Cliente cliente) {
        controladorCadastroCliente.inserirCliente(cliente);
    }

    public void inserirEndereco(Endereco endereco) {
        controladorCadastroCliente.inserirEndereco(endereco);
    }

    public Iterable<Cliente> getAllClientes() {
        return controladorCadastroCliente.getAll();
    }

}
