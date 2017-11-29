package com.example.jonnatas.itsokay.model;

import com.example.jonnatas.itsokay.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

import java.util.Date;

import static java.lang.String.valueOf;

/**
 * Created by jonnatas on 19/11/17.
 */

public class Tarefa {
    private Integer id;
    private String enunciado;
    private Date date;
    private boolean isSelected;

    public Tarefa() {
    }

    public void salvar() {
        DatabaseReference reference = ConfiguracaoFirebase.getFirebase();
        reference.child("tarefas").child(valueOf(getId())).setValue(this);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
