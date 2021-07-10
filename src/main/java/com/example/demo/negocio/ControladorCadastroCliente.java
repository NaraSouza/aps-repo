package com.example.demo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControladorCadastroCliente {

    @Autowired
    private CadastroCliente cadastroCliente;
    @Autowired
    private CadastroEndereco cadastroEndereco;

    public void inserirCliente(Cliente cliente) {
        cadastroCliente.inserir(cliente);
    }

    public void inserirEndereco(Endereco endereco) {
        cadastroEndereco.inserir(endereco);
    }

    public Iterable<Cliente> getAll() {
        return cadastroCliente.getAll();
    }
    
}
