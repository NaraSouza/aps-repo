package com.example.demo.restaurante;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.demo.pedido.Pedido;

@Entity
public class Restaurante {
    @Id
    private Long id;
    @ElementCollection
    private List<Pedido> filaPedidos;
    private String nome;

    public Restaurante(List<Pedido> filaPedidos, String nome) {
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

    public List<Pedido> getFilaPedidos() {
        return filaPedidos;
    }

    public void setFilaPedidos(List<Pedido> filaPedidos) {
        this.filaPedidos = filaPedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
