package com.example.projetofinal.models;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Estudante {
    @Id
    public long id;
    private String nomeDeUsuario;
    private String email;
    private String senha;
    private ToMany<Data> datas;

    public Estudante(String nomeDeUsuario, String email, String senha){
        this.nomeDeUsuario = nomeDeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
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

    public ToMany<Data> getDatas() {
        return datas;
    }

    public void setDatas(ToMany<Data> datas) {
        this.datas = datas;
    }

    public void adicionarData(Data data){
        this.datas.add(data);
    }
}
