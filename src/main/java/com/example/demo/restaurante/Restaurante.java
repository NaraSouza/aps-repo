package com.example.demo.restaurante;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.demo.pedido.Pedido;

@Entity
public class Restaurante {
    @Id
    private Long id;
    @OneToOne
    private FilaPedidos filaPedidos;
    private String nome;

    public Restaurante(FilaPedidos filaPedidos, String nome) {
        this.id = 1l;
        this.filaPedidos = filaPedidos;
        this.nome = nome;
    }

    public Restaurante(Long id){
        this.id = id;
    }

    public Restaurante() {

    }
    
    public Long getId() {
        return id;
    }

    public FilaPedidos getFilaPedidos() {
        return filaPedidos;
    }

    public void setFilaPedidos(FilaPedidos filaPedidos) {
        this.filaPedidos = filaPedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
