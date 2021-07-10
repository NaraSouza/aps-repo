package com.example.demo.negocio;

import com.example.demo.dados.IRepositorioCliente;
import com.example.demo.dados.IRepositorioEndereco;
import com.example.demo.dados.RepositorioClienteBDR;
import com.example.demo.dados.RepositorioEnderecoBDR;

public class FabricaRepositorioBDR implements FabricaAbstrata {
    public FabricaRepositorioBDR() {

    }
    public IRepositorioCliente criarRepositorioCliente(){
        return new RepositorioClienteBDR();
    }
    public IRepositorioEndereco criarRepositorioEndereco(){
        return new RepositorioEnderecoBDR();
    }
}
