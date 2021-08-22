package com.example.demo.item;

import com.example.demo.ApplicationContextHolder;
import com.example.demo.endereco.Endereco;
import com.example.demo.endereco.EnderecoDAO;
import com.example.demo.endereco.IRepositorioEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioItemBDR implements IRepositorioItem {
    @Autowired
    private ItemDAO itemDAO;

    public RepositorioItemBDR(){
        this.itemDAO = ApplicationContextHolder.getContext().getBean(ItemDAO.class);
    }

    @Override
    public void inserir(Item item) {
        itemDAO.save(item);

    }

    @Override
    public void atualizar(Item item) {
        itemDAO.deleteById(item.getId());
        itemDAO.save(item);
    }

    @Override
    public Iterable<Item> getAll() {
        return itemDAO.findAll();
    }
}
