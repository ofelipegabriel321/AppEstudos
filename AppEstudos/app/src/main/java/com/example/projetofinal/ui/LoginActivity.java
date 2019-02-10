package com.example.projetofinal.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetofinal.R;
import com.example.projetofinal.controllers.LoginController;
import com.example.projetofinal.dal.App;

import io.objectbox.BoxStore;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText txtNomeDeUsuario, txtSenha;
    private Button btnLogin;
    private Button btnCadastroEmLogin;
    private BoxStore boxStore;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ligarAtributosComViews();
        tornarBtnLoginClicavelEFuncional();
        tornarBtnCadastroEmLoginClicavelEFuncional();
        instanciarBoxStore();
        instanciarLoginController();
    }

    private void ligarAtributosComViews(){
        txtNomeDeUsuario = findViewById(R.id.idEmailEmLogin);
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
            }
        });
    }


    /*
    A classe logar está analisando se a String de txtNomeDeUsuario está vazia por
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

    private void instanciarLoginController(){
        // Agora passamos a boxStore para a Login Activity formar a Box de Estudante
        loginController = new LoginController(boxStore);
    }

    public void logar(){
        if (verificarSePodeLogar()){
            Toast.makeText(getApplicationContext(), "Login feito com sucesso!", Toast.LENGTH_SHORT).show();
            irParaPainelDoEstudanteActivity();
        }
    }

    public boolean verificarSePodeLogar(){
        if (loginController.verificarSeTextoEstaVazio(txtNomeDeUsuario) ||
                loginController.verificarSeTextoEstaVazio(txtSenha)) {
            if (loginController.verificarSeTextoEstaVazio(txtNomeDeUsuario)) {
                txtNomeDeUsuario.setError("Os campos não podem estar vazios");
            }
            if (loginController.verificarSeTextoEstaVazio(txtSenha)) {
                txtSenha.setError("Os campos não podem estar vazios");
            }
            return false;
        }
        return true;
    }

    public void irParaPainelDoEstudanteActivity(){
        // AGORA IR PRA A OUTRA ACTIVITY
    }

    public void irParaCadastroActivity(){
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }

}
