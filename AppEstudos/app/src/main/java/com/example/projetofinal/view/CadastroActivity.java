package com.example.projetofinal.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetofinal.R;
import com.example.projetofinal.controllers.EstudanteController;
import com.example.projetofinal.dal.App;
import com.example.projetofinal.models.Estudante;

import java.util.Objects;

import io.objectbox.BoxStore;

public class CadastroActivity extends AppCompatActivity {
    private TextInputEditText txtNomeDeUsuario;
    private TextInputEditText txtEmail;
    private TextInputEditText txtSenha;
    private TextInputEditText txtConfirmarSenha;
    private Button btnCadastrar;
    private Estudante estudante;
    private BoxStore boxStore;
    private EstudanteController estudanteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ligarAtributosComViews();
        tornarBtnCadastrarClicavelEFuncional();
        instanciarBoxStore();
        instanciarEstudanteController();
    }

    private void ligarAtributosComViews(){
        txtNomeDeUsuario = findViewById(R.id.idNomeDeUsuarioEmCadastro);
        txtEmail = findViewById(R.id.idEmailEmCadastro);
        txtSenha = findViewById(R.id.idSenhaEmCadastro);
        txtConfirmarSenha = findViewById(R.id.idConfirmeSenhaEmCadastro);
        btnCadastrar = findViewById(R.id.idBtnCadastroEmCadastro);
    }

    private void tornarBtnCadastrarClicavelEFuncional(){
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verificarSePodeCadastrar()) {
                    estudante = new Estudante(Objects.requireNonNull(txtNomeDeUsuario.getText()).toString(),
                            Objects.requireNonNull(txtEmail.getText()).toString(),
                            Objects.requireNonNull(txtSenha.getText()).toString());
                    estudanteController.salvarEstudante(estudante);
                    irParaLoginActivity();
                    finish();
                }
            }
        });
    }

    private void instanciarBoxStore(){
        boxStore = ((App) getApplication()).getBoxStore();
    }

    private void instanciarEstudanteController(){
        estudanteController = new EstudanteController(boxStore);
    }

    public boolean verificarSePodeCadastrar(){
        if (estudanteController.verificarSeTextoEstaVazio(txtNomeDeUsuario) ||
                estudanteController.verificarSeTextoEstaVazio(txtEmail) ||
                estudanteController.verificarSeTextoEstaVazio(txtSenha) ||
                estudanteController.verificarSeTextoEstaVazio(txtConfirmarSenha) ||
                estudanteController.verificarSeNomeDeUsuarioExiste(txtNomeDeUsuario) ||
                estudanteController.verificarSeEmailExiste(txtEmail) ||
                !estudanteController.verificarSeSenhaEConfirmarSenhaEstaoCorretos(txtSenha, txtConfirmarSenha)){

            if (estudanteController.verificarSeTextoEstaVazio(txtNomeDeUsuario)) {
                txtNomeDeUsuario.setError("Os campos não podem estar vazios!");
            }

            else if (estudanteController.verificarSeNomeDeUsuarioExiste(txtNomeDeUsuario)){
                txtNomeDeUsuario.setError("Esse nome de usuário já está sendo usado!");
            }

            if (estudanteController.verificarSeTextoEstaVazio(txtEmail)) {
                txtEmail.setError("Os campos não podem estar vazios!");
            }

            else if (estudanteController.verificarSeEmailExiste(txtEmail)){
                txtEmail.setError("Esse email já foi cadastrado!");
            }

            if (estudanteController.verificarSeTextoEstaVazio(txtSenha) ||
                    estudanteController.verificarSeTextoEstaVazio(txtConfirmarSenha)){
                if (estudanteController.verificarSeTextoEstaVazio(txtSenha)){
                    txtSenha.setError("Os campos não podem estar vazios!");
                }
                if (estudanteController.verificarSeTextoEstaVazio(txtConfirmarSenha)){
                    txtConfirmarSenha.setError("Os campos não podem estar vazios!");
                }
            }

            else if (!estudanteController.verificarSeSenhaEConfirmarSenhaEstaoCorretos(txtSenha, txtConfirmarSenha)){
                txtSenha.setError("A senha ou o confirmo da senha estão errados!");
                txtConfirmarSenha.setError("A senha ou o confirmo da senha estão errados!");
            }

            return false;
        }

        return true;
    }

    public void irParaLoginActivity(){
        startActivity(new Intent(this, LoginActivity.class));
    }
}
