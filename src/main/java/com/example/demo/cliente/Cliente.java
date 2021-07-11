package com.example.demo.cliente;

import com.example.demo.endereco.Endereco;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String senha;
    @OneToOne
    private Endereco endereco;
    private String email;

    public Cliente(Long id, String nome, Endereco endereco, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        this.email = email;
    }

    public Cliente () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return this.id + " " + this.nome;
    }
}
