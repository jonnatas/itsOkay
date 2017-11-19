package com.example.jonnatas.itsokay.model;

import com.example.jonnatas.itsokay.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

import static java.lang.String.valueOf;

/**
 * Created by jonnatas on 19/11/17.
 */

public class Tarefa {
    private Integer id;
    private String enunciado;

    public Tarefa() {
    }

    public void salvar() {
        DatabaseReference reference = ConfiguracaoFirebase.getFirebase();
        reference.child("tarefas").child(valueOf(getId())).setValue(this);
    }

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
}
