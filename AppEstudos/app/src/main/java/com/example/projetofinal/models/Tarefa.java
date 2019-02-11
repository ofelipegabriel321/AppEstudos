package com.example.projetofinal.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Tarefa {
    @Id
    public long id;
    private String titulo;
    private String descricao;
    private String horaInicio;
    private String horaTermino;
    private ToOne<Data> data;

    public Tarefa(){}

    public Tarefa(String titulo, String descricao, String horaInicio, String horaTermino) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public ToOne<Data> getData() {
        return data;
    }

    public void setData(ToOne<Data> data) {
        this.data = data;
    }
}
