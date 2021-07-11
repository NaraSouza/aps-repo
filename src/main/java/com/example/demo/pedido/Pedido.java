package com.example.demo.pedido;

import com.example.demo.avaliacao.Avaliacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
    @Id
    private Long id;
    @OneToOne
    private Avaliacao avaliacao;
    @OneToOne
    private Item itens;
    @OneToOne
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Long id) {
        this.id = id;
    }

    public Pedido(Avaliacao avaliacao, Item itens, StatusPedido status) {
        this.id = 1l;
        this.avaliacao = avaliacao;
        this.itens = itens;
        this.status = status;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Item getItens() {
        return itens;
    }

    public void setItens(Item itens) {
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
