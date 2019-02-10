package com.example.projetofinal.controllers;

import android.text.TextUtils;
import android.widget.TextView;

import com.example.projetofinal.models.Estudante;

import java.util.Objects;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class LoginController {
    private Box<Estudante> estudanteBox;

    public LoginController(BoxStore boxStore){
        // O boxFor(Estudante.class) faz com que a Box de Estudante seja criada,
        // agora você pode armazenar e recuperar dados do banco de dados.
        estudanteBox = boxStore.boxFor(Estudante.class);
    }

    public boolean verificarSeTextoEstaVazio(TextView texto){
        return TextUtils.isEmpty(Objects.requireNonNull(texto.getText()).toString().trim());
    }
}
