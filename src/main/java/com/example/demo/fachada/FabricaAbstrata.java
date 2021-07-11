package com.example.demo.negocio;

import com.example.demo.dados.IRepositorioCliente;
import com.example.demo.dados.IRepositorioEndereco;

public interface FabricaAbstrata {
    public IRepositorioCliente criarRepositorioCliente();
    public IRepositorioEndereco criarRepositorioEndereco();
}
