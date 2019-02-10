package com.example.projetofinal.dal;

import android.app.Application;

import com.example.projetofinal.models.MyObjectBox;

import io.objectbox.BoxStore;

// Depois de finalizar a classe, vá na AndroidManifest.xml e faça o código android:name="dal.App.xml"
public class App extends Application {
    // Um BoxStore é a interface que se liga diretamente com o banco de dados
    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        inicializarObjectBox();
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }

    private void inicializarObjectBox(){
        // OBS: Deve ser criada uma classe e executar o app antes de escrever o código abaixo,
        // só assim o MyObjectBox vai poder ser chamado.
        // Instancia a classe BoxStore do MyObjectBox no atributo boxStore. O builder serve para
        // que seja facilitada a criação do boxStore.
        boxStore = MyObjectBox.builder().androidContext(this).build();
    }

}
