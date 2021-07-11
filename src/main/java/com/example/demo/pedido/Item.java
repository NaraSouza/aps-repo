package com.example.demo.pedido;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    private Long id;
    private String descricao;

    public Item(String descricao){
        this.id = 1l;
        this.descricao = descricao;
    }

    public Item(){

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
