package com.example.sistemadeencuestas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CreacionEncuestaActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_encuesta_activity);
    }


    public void Regresar(View view){
        Intent reg = new Intent(this, MainActivity.class);
        startActivity(reg);
    }
}
