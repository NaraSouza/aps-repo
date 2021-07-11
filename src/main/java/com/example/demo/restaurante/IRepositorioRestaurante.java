package com.example.demo.restaurante;

public interface IRepositorioRestaurante {

    public void inserir(Restaurante restaurante);

    public void atualizar(Restaurante restaurante);

    public Iterable<Restaurante> getAll();

}
