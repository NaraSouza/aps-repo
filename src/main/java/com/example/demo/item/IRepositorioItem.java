package com.example.demo.item;

import com.example.demo.item.Item;

public interface IRepositorioItem {

    public void inserir(Item item);

    public void atualizar(Item item);

    public Iterable<Item> getAll();

}
