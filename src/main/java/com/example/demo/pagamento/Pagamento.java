package com.example.demo.pagamento;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pagamento {
    @Id
    private Long id;
    private String formaPagamento;
    private Double valor;

    public Pagamento() {
    }

    public Pagamento(Long id) {
        this.id = id;
    }

    public Pagamento(String formaPagamento, Double valor) {
        this.id = 1l;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
    }


    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }
}
