package com.example.projetofinal.controllers;

import android.text.TextUtils;
import android.widget.TextView;

import com.example.projetofinal.models.Estudante;

import java.util.List;
import java.util.Objects;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class EstudanteController {
    private Box<Estudante> estudanteBox;

    public EstudanteController(BoxStore boxStore){
        // O boxFor(Estudante.class) faz com que a Box de Estudante seja criada,
        // agora você pode armazenar e recuperar dados do banco de dados.
        estudanteBox = boxStore.boxFor(Estudante.class);
    }

    public void salvarEstudante(Estudante estudante){
        estudanteBox.put(estudante);
    }

    public boolean verificarSeTextoEstaVazio(TextView textView){
        return TextUtils.isEmpty(Objects.requireNonNull(textView.getText()).toString().trim());
    }

    public boolean verificarSeEmailExiste(TextView txtEmail){
        String emailVerificado = txtEmail.getText().toString();
        List<Estudante> estudanteList = estudanteBox.getAll();
        for (int i = 0; i<estudanteList.size(); i++){
            if (emailVerificado.equals(estudanteList.get(i).getEmail())){
                return true;
            }
        }
        return false;
    }

    public boolean verificarSeSenhaEstaCorreta(TextView txtEmail, TextView txtSenha){
        String emailVerificado = txtEmail.getText().toString();
        String senhaVerificada = txtSenha.getText().toString();
        List<Estudante> estudanteList = estudanteBox.getAll();
        for (int i = 0; i<estudanteList.size(); i++){
            if (emailVerificado.equals(estudanteList.get(i).getEmail())){
                return senhaVerificada.equals(estudanteList.get(i).getSenha());
            }
        }
        return false;
    }

    public boolean verificarSeNomeDeUsuarioExiste(TextView txtNomeDeUsuario){
        String nomeDeUsuarioVerificado = txtNomeDeUsuario.getText().toString();
        List<Estudante> estudanteList = estudanteBox.getAll();
        for (int i = 0; i<estudanteList.size(); i++){
            if (nomeDeUsuarioVerificado.equals(estudanteList.get(i).getNomeDeUsuario())){
                return true;
            }
        }
        return false;
    }

    public boolean verificarSeSenhaEConfirmarSenhaEstaoCorretos(TextView txtSenha, TextView txtConfirmarSenha){
        String senha = txtSenha.getText().toString();
        String verificarSenha = txtConfirmarSenha.getText().toString();
        return senha.equals(verificarSenha);
    }
}
