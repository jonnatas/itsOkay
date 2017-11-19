package com.example.jonnatas.itsokay.model;

import com.example.jonnatas.itsokay.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by jonnatas on 19/11/17.
 */

public class UsuarioTarefa {
    private String tarefa_id;
    private String usuario_id;
    private String resposta;

    public UsuarioTarefa() {
    }

    public void salvar() {
        DatabaseReference reference = ConfiguracaoFirebase.getFirebase();
        reference.child("usuario_tarefa").child(getTarefa_id()).child(getUsuario_id()).setValue(getResposta());
    }

    public String getTarefa_id() {
        return tarefa_id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void setTarefa_id(String tarefa_id) {
        this.tarefa_id = tarefa_id;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }
}
