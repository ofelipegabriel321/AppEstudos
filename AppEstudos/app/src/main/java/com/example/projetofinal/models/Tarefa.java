package com.example.projetofinal.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Tarefa extends Agendamento {
    @Id
    public long id;
    private String titulo;
    private String descricao;
    private String horaInicializacao;
    private String horaTermino;
    private ToOne<Data> data;

    public Tarefa() {
    }

    public Tarefa(String descricao, String horaInicializacao, String titulo, String horaTermino) {
        super(descricao, horaInicializacao);
        this.titulo = titulo;
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

    public String getHoraInicializacao() {
        return horaInicializacao;
    }

    public void setHoraInicializacao(String horaInicializacao) {
        this.horaInicializacao = horaInicializacao;
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
