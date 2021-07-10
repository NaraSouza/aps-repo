package com.example.demo.negocio;

import com.example.demo.dados.IRepositorioCliente;
import com.example.demo.dados.IRepositorioEndereco;
import org.springframework.beans.factory.annotation.Autowired;
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
