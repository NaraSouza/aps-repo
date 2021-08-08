package com.example.demo.pagamento;

import org.springframework.stereotype.Component;

@Component
public class CadastroPagamento {

    private IRepositorioPagamento repositorioPagamento;

    public CadastroPagamento(IRepositorioPagamento repositorioPagamento){
        this.repositorioPagamento = repositorioPagamento;
    }

    public void inserir(Pagamento pagamento) {
        repositorioPagamento.inserir(pagamento);
    }

    public void atualizar(Pagamento pagamento) {
        repositorioPagamento.atualizar(pagamento);
    }

}
