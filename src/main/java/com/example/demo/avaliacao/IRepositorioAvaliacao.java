package com.example.demo.avaliacao;

public interface IRepositorioAvaliacao {

    public void inserir(Avaliacao avaliacao);

    public Iterable<Avaliacao> getAll();

}
