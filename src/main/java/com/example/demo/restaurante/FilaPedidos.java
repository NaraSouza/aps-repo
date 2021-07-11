package com.example.demo.restaurante;

import com.example.demo.pedido.Pedido;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FilaPedidos {
    private int actualIndex;
    @OneToOne
    private Pedido[] pedido;
    @Id
    private Long id;

    public FilaPedidos(Pedido pedido) {
        this.pedido = new Pedido[100];
        this.actualIndex = 0;
        this.id = 1l;
    }

    public FilaPedidos() {

    }

    public Pedido getPedido(int index) {
        return pedido[index];
    }

    public void inserirPedido(Pedido pedido){
       this.pedido[this.actualIndex] = pedido;
       this.actualIndex += 1;
    }
}
