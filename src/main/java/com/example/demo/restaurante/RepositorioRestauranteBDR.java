package com.example.demo.restaurante;

import com.example.demo.ApplicationContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioRestauranteBDR implements IRepositorioRestaurante {
    @Autowired
    private RestauranteDAO restauranteDAO;

    public RepositorioRestauranteBDR(){
        this.restauranteDAO = ApplicationContextHolder.getContext().getBean(RestauranteDAO.class);
    }

    @Override
    public void inserir(Restaurante restaurante) {
        restauranteDAO.save(restaurante);

    }

    public void atualizar(Restaurante restaurante) {
        restauranteDAO.deleteById(restaurante.getId());
        restauranteDAO.save(restaurante);
    }

    @Override
    public Iterable<Restaurante> getAll() {
        return restauranteDAO.findAll();
    }
}
