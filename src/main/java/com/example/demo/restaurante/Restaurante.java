package com.example.demo.restaurante;

import com.example.demo.avaliacao.Avaliacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Restaurante {
    @Id
    private Long id;
    @OneToOne
    private FilaPedidos filaPedidos;
    @OneToOne
    private Avaliacao avaliacao;
    private String nome;

    public Restaurante(FilaPedidos filaPedidos, Avaliacao avaliacao, String nome) {
        this.id = 1l;
        this.filaPedidos = filaPedidos;
        this.avaliacao = avaliacao;
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

    public Avaliacao getAvaliacao() {
        return this.avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
