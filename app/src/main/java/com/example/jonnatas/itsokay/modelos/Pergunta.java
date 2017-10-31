package com.example.jonnatas.itsokay.modelos;

/**
 * Created by jonnatas on 20/10/17.
 */

public class Pergunta {
    private Integer id;
    private String enunciado;
    private Integer categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
}
