package com.example.demo.pedido;

import com.example.demo.ApplicationContextHolder;
import com.example.demo.endereco.Endereco;
import com.example.demo.endereco.EnderecoDAO;
import com.example.demo.endereco.IRepositorioEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioPedidoBDR implements IRepositorioPedido {
    @Autowired
    private PedidoDAO pedidoDAO;

    public RepositorioPedidoBDR(){
        this.pedidoDAO = ApplicationContextHolder.getContext().getBean(PedidoDAO.class);
    }

    @Override
    public void inserir(Pedido pedido) {
        pedidoDAO.save(pedido);

    }

    @Override
    public void atualizar(Pedido pedido) {
        pedidoDAO.deleteById(pedido.getId());
        pedidoDAO.save(pedido);
    }

    @Override
    public Iterable<Pedido> getAll() {
        return pedidoDAO.findAll();
    }
}
