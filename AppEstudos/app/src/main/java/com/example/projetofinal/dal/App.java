package com.example.projetofinal.dal;

import android.app.Application;

import com.example.projetofinal.models.MyObjectBox;

import io.objectbox.BoxStore;

public class App extends Application {
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
        boxStore = MyObjectBox.builder().androidContext(this).build();
    }
}
