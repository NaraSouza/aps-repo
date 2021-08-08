package com.example.demo.pagamento;

import com.example.demo.ApplicationContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioPagamentoBDR implements IRepositorioPagamento {
    @Autowired
    private PagamentoDAO pagamentoDAO;

    public RepositorioPagamentoBDR(){
        this.pagamentoDAO = ApplicationContextHolder.getContext().getBean(PagamentoDAO.class);
    }

    @Override
    public void inserir(Pagamento pagamento) {
        pagamentoDAO.save(pagamento);

    }

    @Override
    public void atualizar(Pagamento pagamento) {
        pagamentoDAO.deleteById(pagamento.getId());
        pagamentoDAO.save(pagamento);
    }

    @Override
    public Iterable<Pagamento> getAll() {
        return pagamentoDAO.findAll();
    }
}
