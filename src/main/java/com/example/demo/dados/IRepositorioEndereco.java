package com.example.demo.dados;

import com.example.demo.negocio.Cliente;
import com.example.demo.negocio.Endereco;

public interface IRepositorioEndereco {

    public void inserir(Endereco endereco);

    public Iterable<Endereco> getAll();

}
