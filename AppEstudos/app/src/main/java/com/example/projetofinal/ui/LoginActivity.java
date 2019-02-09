package com.example.projetofinal.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetofinal.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText txtNomeDeUsuario, txtSenha;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        componentesLogin();
        clickLogin();
    }

    public void componentesLogin(){
        txtNomeDeUsuario = findViewById(R.id.idEmailEmLogin);
        txtSenha = findViewById(R.id.idSenhaEmLogin);
        btnLogin = findViewById(R.id.idBtnLogin);
    }

    public void clickLogin(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    /*
    A classe login está analisando se a String de txtNomeDeUsuario está vazia por
    meio do método isEmpty. O trim() serve para fazer com que espaços no começo e
    final da String sumam caso existam.
    Em algum caso da String do Usuario ou da Senha estar vazia, será exibido uma
    mensagem com o método setError.
    */
    public void login(){
        if(TextUtils.isEmpty(Objects.requireNonNull(txtNomeDeUsuario.getText()).toString().trim())){
            txtNomeDeUsuario.setError("Os campos não podem estar vazios");
        }
        else if (TextUtils.isEmpty(Objects.requireNonNull(txtSenha.getText()).toString().trim())){
            txtSenha.setError("Os campos não podem estar vazios");
        }
        else{
            Toast.makeText(getApplicationContext(), "Login feito com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

}
