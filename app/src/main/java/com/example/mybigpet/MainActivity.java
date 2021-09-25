package com.example.mybigpet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView user = findViewById(R.id.usuario);
        TextView password = findViewById(R.id.senha);
        Button join = findViewById(R.id.entrar);
        join.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validate(user.getText().toString(),password.getText().toString());
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void validate(String user, String senha){
        TextView texto = findViewById(R.id.erro);
        if (user.toLowerCase(Locale.ROOT).equals("admin") && senha.equals("admin")){
            Intent intent = new Intent(MainActivity.this, menu.class);
            startActivity(intent);
        }
        else{
            texto.setText("Login ou Senha invalidos");
        }
    }

}