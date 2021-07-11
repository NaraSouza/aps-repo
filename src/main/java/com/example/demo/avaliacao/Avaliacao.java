package com.example.demo.avaliacao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avaliacao {
    @Id
    private Long id;
    private Double nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    private String comentario;

    public Avaliacao(Double nota, String comentario) {
        this.id = 1l;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Avaliacao() {

    }
}
