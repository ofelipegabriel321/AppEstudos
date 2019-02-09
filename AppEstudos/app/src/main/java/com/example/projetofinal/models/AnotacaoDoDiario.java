package com.example.projetofinal.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class AnotacaoDoDiario {
    @Id
    public long id;
    private String texto;
    private String hora;
    private ToOne<Data> data;

    public AnotacaoDoDiario(String texto, String hora){
        this.texto = texto;
        this.hora = hora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ToOne<Data> getData() {
        return data;
    }

    public void setData(ToOne<Data> data) {
        this.data = data;
    }
}
