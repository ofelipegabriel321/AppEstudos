package com.example.projetofinal.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetofinal.R;
import com.example.projetofinal.controllers.EstudanteController;
import com.example.projetofinal.dal.App;

import io.objectbox.BoxStore;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText txtEmail;
    private TextInputEditText txtSenha;
    private Button btnLogin;
    private Button btnCadastroEmLogin;
    private BoxStore boxStore;
    private EstudanteController estudanteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ligarAtributosComViews();
        tornarBtnLoginClicavelEFuncional();
        tornarBtnCadastroEmLoginClicavelEFuncional();
        instanciarBoxStore();
        instanciarEstudanteController();
    }

    public EstudanteController getEstudanteController() {
        return estudanteController;
    }

    public void setEstudanteController(EstudanteController estudanteController) {
        this.estudanteController = estudanteController;
    }

    private void ligarAtributosComViews(){
        txtEmail = findViewById(R.id.idEmailEmLogin);
        txtSenha = findViewById(R.id.idSenhaEmLogin);
        btnLogin = findViewById(R.id.idBtnLogin);
        btnCadastroEmLogin = findViewById(R.id.idBtnCadastroEmLogin);
    }

    private void tornarBtnLoginClicavelEFuncional(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
    }

    private void tornarBtnCadastroEmLoginClicavelEFuncional(){
        btnCadastroEmLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaCadastroActivity();
                finish();
            }
        });
    }


    /*
    A classe logar está analisando se a String de txtEmail está vazia por
    meio do método isEmpty. O trim() serve para fazer com que espaços no começo e
    final da String sumam caso existam.
    Em algum caso da String do Usuario ou da Senha estar vazia, será exibido uma
    mensagem com o método setError.
    */

    private void instanciarBoxStore(){
        // O ((App) getApplication()).getBoxStore() faz com que o BoxStore possa
        // ser obtido.
        boxStore = ((App) getApplication()).getBoxStore();
    }

    private void instanciarEstudanteController(){
        // Agora passamos a boxStore para a Login Activity formar a Box de Estudante
        estudanteController = new EstudanteController(boxStore);
    }

    public void logar(){
        if (verificarSePodeLogar()){
            Toast.makeText(getApplicationContext(), "Login feito com sucesso!", Toast.LENGTH_SHORT).show();
            irParaPainelDoEstudanteActivity();
        }
    }

    public boolean verificarSePodeLogar(){
        if (estudanteController.verificarSeTextoEstaVazio(txtEmail) ||
                estudanteController.verificarSeTextoEstaVazio(txtSenha) ||
                !estudanteController.verificarSeEmailExiste(txtEmail) ||
                !estudanteController.verificarSeSenhaEstaCorreta(txtEmail, txtSenha)){

            if (estudanteController.verificarSeTextoEstaVazio(txtEmail)) {
                txtEmail.setError("Os campos não podem estar vazios!");
            }

            else if (!estudanteController.verificarSeEmailExiste(txtEmail)){
                txtEmail.setError("Email inexistente!");
            }

            if (estudanteController.verificarSeTextoEstaVazio(txtSenha)) {
                txtSenha.setError("Os campos não podem estar vazios!");
            }

            else if (estudanteController.verificarSeEmailExiste(txtEmail) &&
                    !estudanteController.verificarSeSenhaEstaCorreta(txtEmail, txtSenha)){
                txtSenha.setError("Senha incorreta!");
            }

            return false;
        }

        return true;
    }

    public void irParaPainelDoEstudanteActivity(){
        startActivity(new Intent(this, PainelDoEstudanteActivity.class));
    }

    public void irParaCadastroActivity(){
        startActivity(new Intent(this, CadastroActivity.class));
    }

}
