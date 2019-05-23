package com.example.sistemadeencuestas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CrearEncuestaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_encuesta);
    }

    public void CrearPregunta(View view){
        Intent crear = new Intent(this, PregActivity.class);
        startActivity(crear);
    }


    public void CrearMateria(View view){
        Intent crear = new Intent(this, MateriaActivity.class);
        startActivity(crear);
    }

    public void CrearDocente(View view){
        Intent crear = new Intent(this, DocenteActivity.class);
        startActivity(crear);
    }
    public void Regresar(View view){
        Intent reg = new Intent(this, MainActivity.class);
        startActivity(reg);
    }


}
