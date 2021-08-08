package com.example.demo.controllers;

import com.example.demo.cliente.IRepositorioCliente;
import com.example.demo.endereco.IRepositorioEndereco;
import com.example.demo.cliente.CadastroCliente;
import com.example.demo.endereco.CadastroEndereco;
import com.example.demo.cliente.Cliente;
import com.example.demo.endereco.Endereco;
import org.springframework.stereotype.Component;

@Component
public class ControladorCadastroCliente {

    private CadastroCliente cadastroCliente;
    private CadastroEndereco cadastroEndereco;

    public ControladorCadastroCliente(IRepositorioCliente repositorioCliente, IRepositorioEndereco repositorioEndereco){
        this.cadastroCliente = new CadastroCliente(repositorioCliente);
        this.cadastroEndereco = new CadastroEndereco(repositorioEndereco);
    }

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
