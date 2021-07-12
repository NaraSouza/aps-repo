package com.example.demo.restaurante;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.avaliacao.Avaliacao;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Restaurante {
    @Id
    private Long id;
    @OneToOne
    private FilaPedidos filaPedidos;
    @ElementCollection
    private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
    private String nome;

    public Restaurante(FilaPedidos filaPedidos, List<Avaliacao> avaliacoes, String nome) {
        this.id = 1l;
        this.filaPedidos = filaPedidos;
        this.avaliacoes = avaliacoes;
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

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
