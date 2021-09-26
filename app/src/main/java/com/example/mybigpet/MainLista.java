package com.example.mybigpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class MainLista extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        getSupportActionBar().hide();



        //INSERT INTO TABLE values (...)
        //appDataBase.insert("animais",objAnimal);
        //List<Animal> animals = appDataBase.get();
        //System.out.println(animals);
    }
}