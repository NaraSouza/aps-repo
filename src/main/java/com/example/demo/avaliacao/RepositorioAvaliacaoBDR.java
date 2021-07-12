package com.example.demo.avaliacao;

import com.example.demo.ApplicationContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioAvaliacaoBDR implements IRepositorioAvaliacao {
    @Autowired
    private AvaliacaoDAO avaliacaoDAO;

    public RepositorioAvaliacaoBDR(){
        this.avaliacaoDAO = ApplicationContextHolder.getContext().getBean(AvaliacaoDAO.class);
    }

    @Override
    public void inserir(Avaliacao avaliacao) {
        avaliacaoDAO.save(avaliacao);

    }

    @Override
    public Iterable<Avaliacao> getAll() {
        return avaliacaoDAO.findAll();
    }
}
