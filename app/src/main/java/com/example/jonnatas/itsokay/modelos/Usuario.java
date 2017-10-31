package com.example.jonnatas.itsokay.modelos;

import java.util.Date;

/**
 * Created by jonnatas on 20/10/17.
 */

public class Usuario {
    private Integer id;
    private String nome;
    private Date date_nascimento;
    private Character sexo;
    private String email;
    private String senha;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDate_nascimento() {
        return date_nascimento;
    }

    public void setDate_nascimento(Date date_nascimento) {
        this.date_nascimento = date_nascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
