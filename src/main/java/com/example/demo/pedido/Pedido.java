package com.example.demo.pedido;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.demo.item.Item;

@Entity
public class Pedido {
    @Id
    private Long id;
    @ElementCollection
    private List<Item> itens = new ArrayList<Item>();
    @OneToOne
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Long id) {
        this.id = id;
    }

    public Pedido(List<Item> itens, StatusPedido status) {
        this.id = 1l;
        this.itens = itens;
        this.status = status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
