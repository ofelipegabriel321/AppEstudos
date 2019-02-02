package com.example.projetofinal.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetofinal.R;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText txtNomeDeUsuario, txtSenha;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtNomeDeUsuario = (TextInputEditText) findViewById(R.id.idNomeDeUsuario);
        txtSenha = (TextInputEditText) findViewById(R.id.idSenha);
        btnLogin = (Button) findViewById(R.id.idBtnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void login(){
        if(TextUtils.isEmpty(txtNomeDeUsuario.getText().toString().trim()) ||
                TextUtils.isEmpty(txtSenha.getText().toString().trim())){
            txtSenha.setError("Os campos não podem estar vazios");
            txtNomeDeUsuario.setError("Os campos não podem estar vazios");
        }
        else{
            Toast.makeText(getApplicationContext(), "Login feito com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }
}
