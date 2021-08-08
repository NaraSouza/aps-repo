package com.example.demo.pagamento;

import com.example.demo.pagamento.Pagamento;

public interface IRepositorioPagamento {

    public void inserir(Pagamento pagamento);

    public void atualizar(Pagamento pagamento);

    public Iterable<Pagamento> getAll();

}
