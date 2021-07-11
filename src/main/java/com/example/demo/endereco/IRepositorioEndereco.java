package com.example.demo.dados;

import com.example.demo.endereco.Endereco;

public interface IRepositorioEndereco {

    public void inserir(Endereco endereco);

    public Iterable<Endereco> getAll();

}
