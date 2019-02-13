package com.example.projetofinal.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class AnotacaoDoDiario extends Agendamento {
    @Id
    public long id;
    private String descricao;
    private String horaInicializacao;
    private ToOne<Data> data;

    public AnotacaoDoDiario(){}

    public AnotacaoDoDiario(String descricao, String horaInicializacao){
        super(descricao, horaInicializacao);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ToOne<Data> getData() {
        return data;
    }

    public void setData(ToOne<Data> data) {
        this.data = data;
    }
}
