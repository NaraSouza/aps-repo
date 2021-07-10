package com.example.demo.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco {

    @Id
    private Long id;
    private String rua;
    private String cidade;
    private String bairro;
    private String complemento;
    private String CEP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                '}';
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Endereco(Long id, String rua, String cidade, String bairro, String complemento, String cep) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
        CEP = cep;
    }

    public Endereco() {

    }
}