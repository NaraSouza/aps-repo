package com.example.demo.endereco;

import com.example.demo.endereco.Endereco;

public interface IRepositorioEndereco {

    public void inserir(Endereco endereco);

    public Iterable<Endereco> getAll();

}
