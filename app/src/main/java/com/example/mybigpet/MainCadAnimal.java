package com.example.mybigpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainCadAnimal extends AppCompatActivity {
    private Animal objAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadanimal);
        getSupportActionBar().hide();
        Button cadastro = findViewById(R.id.finalizar_cadastro);
        Button cancelar = findViewById(R.id.cancelar);
        cadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                save_db();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                exit();
            }
        });
    }
    public void save_db(){
        try{
            TextView nome = findViewById(R.id.nome);
            TextView idade = findViewById(R.id.idade);
            TextView sexo = findViewById(R.id.sexo);
            TextView peso = findViewById(R.id.peso);
            TextView raca = findViewById(R.id.raca);
            TextView pai = findViewById(R.id.pai);
            TextView mae = findViewById(R.id.mae);

            AppDataBase appDataBase = new AppDataBase(this);
            objAnimal = new Animal();
            objAnimal.setNome(nome.getText().toString());
            objAnimal.setIdade(Integer.parseInt(idade.getText().toString()));
            objAnimal.setSexo(Integer.parseInt(sexo.getText().toString()));
            objAnimal.setPeso(Float.parseFloat(peso.getText().toString()));
            objAnimal.setRaca(raca.getText().toString());
            objAnimal.setMae(mae.getText().toString());
            objAnimal.setPai(pai.getText().toString());

            appDataBase.insertion("animais",objAnimal);
        }
        catch(SQLException e){
            Log.e("DB_LOG","onCreate:"+e.getLocalizedMessage()  );
        }
    }
    public void exit(){
        Intent intent = new Intent(MainCadAnimal.this, MainMenu.class);
        startActivity(intent);
    }
}