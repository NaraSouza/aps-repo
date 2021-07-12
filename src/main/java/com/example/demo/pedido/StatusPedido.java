package com.example.demo.pedido;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StatusPedido {
    @Id
    private Long id;
    private String status;

    public StatusPedido(String status) {
        this.id = 1l;
        this.status = status;
    }

    public StatusPedido() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
