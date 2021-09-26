package com.example.mybigpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        Button disconnect = findViewById(R.id.desconectar);
        Button listar = findViewById(R.id.listar);
        Button cadastro = findViewById(R.id.cadastrar);
        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToList();
            }
        });
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToCad();
            }
        });
    }

    public void exit(){
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        startActivity(intent);
    }
    public void changeToList(){
        Intent intent = new Intent(MainMenu.this, MainLista.class);
        startActivity(intent);
    }
    public void changeToCad(){
        Intent intent = new Intent(MainMenu.this, MainCadAnimal.class);
        startActivity(intent);
    }
}