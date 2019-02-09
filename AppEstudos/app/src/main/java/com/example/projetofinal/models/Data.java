package com.example.projetofinal.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
public class Data {
    @Id
    public long id;
    private String data;
    private ToOne<Estudante> estudante;
    private ToMany<Tarefa> tarefas;
    private ToMany<AnotacaoDoDiario> anotacoesDoDiario;

    public Data(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ToOne<Estudante> getEstudante() {
        return estudante;
    }

    public void setEstudante(ToOne<Estudante> estudante) {
        this.estudante = estudante;
    }

    public ToMany<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ToMany<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public ToMany<AnotacaoDoDiario> getAnotacoesDoDiario() {
        return anotacoesDoDiario;
    }

    public void setAnotacoesDoDiario(ToMany<AnotacaoDoDiario> anotacoesDoDiario) {
        this.anotacoesDoDiario = anotacoesDoDiario;
    }

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa){
        tarefas.remove(tarefa);
    }

    public void adicionarAnotacaoDoDiario(AnotacaoDoDiario anotacaoDoDiario){
        anotacoesDoDiario.add(anotacaoDoDiario);
    }

    public void removerAnotacaoDoDiario(AnotacaoDoDiario anotacaoDoDiario){
        anotacoesDoDiario.remove(anotacaoDoDiario);
    }
}
