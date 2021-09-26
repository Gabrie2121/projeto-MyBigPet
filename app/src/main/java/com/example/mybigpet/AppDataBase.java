package com.example.mybigpet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DBName = "Animais.sqlite";
    public static final int DBVersion = 1;

    SQLiteDatabase db;
    public AppDataBase(@Nullable Context context){
        super(context, DBName,null,DBVersion);
        db = getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelaAnimais = "CREATE TABLE animais (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade INTEGER,sexo INTEGER, raca TEXT,pai TEXT,mae TEXT,peso NUMERIC)";
        try{
            db.execSQL(tabelaAnimais);
        }
        catch(SQLException e){
            Log.e("DB_LOG","onCreate:"+e.getLocalizedMessage()  );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    //INSERT INTO TABLE values (...)
    public boolean insert(String tabela,Animal dados){
        ContentValues values = new ContentValues();

        values.put("nome",dados.getNome());
        values.put("idade",dados.getIdade());
        values.put("sexo",dados.getSexo());
        values.put("raca",dados.getRaca());
        values.put("pai",dados.getPai());
        values.put("mae",dados.getMae());
        values.put("peso",dados.getPeso());

        return db.insert(tabela,null, values)>0;
    }
    public List get(){
        Cursor c = db.rawQuery("SELECT * FROM animais",null);
        List<Animal> animais = new ArrayList<Animal>();
        int i = 0;
        if(c.getCount() > 0){
            c.moveToFirst();
            do{
                Animal animal = new Animal();
                animal.setId(c.getInt(0));
                animal.setNome(c.getString(1));
                animal.setIdade(c.getInt(2));
                animal.setSexo(c.getInt(3));
                animal.setRaca(c.getString(4));
                animal.setPai(c.getString(5));
                animal.setMae(c.getString(6));
                animal.setPeso(c.getDouble(7));
                animais.add(animal);
            }while(c.moveToNext());
            c.close();
        }
        return animais;
    }
}
