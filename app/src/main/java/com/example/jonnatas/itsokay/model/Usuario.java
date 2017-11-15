package com.example.jonnatas.itsokay.model;

import com.example.jonnatas.itsokay.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by jonnatas on 14/11/17.
 */

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String date;
    private Integer amor;
    private Integer fe;
    private Integer tolerancia;
    private Integer generosidade;
    private Integer sabedoria;

    public Usuario() {

    }

    public void salvar() {
        DatabaseReference reference = ConfiguracaoFirebase.getFirebase();
        reference.child("usuarios").child(getId()).setValue(this);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAmor() {
        return amor;
    }

    public void setAmor(Integer amor) {
        this.amor = amor;
    }

    public Integer getFe() {
        return fe;
    }

    public void setFe(Integer fe) {
        this.fe = fe;
    }

    public Integer getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(Integer tolerancia) {
        this.tolerancia = tolerancia;
    }

    public Integer getGenerosidade() {
        return generosidade;
    }

    public void setGenerosidade(Integer generosidade) {
        this.generosidade = generosidade;
    }

    public Integer getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(Integer sabedoria) {
        this.sabedoria = sabedoria;
    }
}
