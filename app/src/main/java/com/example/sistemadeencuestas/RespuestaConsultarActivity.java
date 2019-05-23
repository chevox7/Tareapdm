package com.example.sistemadeencuestas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RespuestaConsultarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_respuesta_consultar);
        setContentView(R.layout.activity_respuesta_consultar);
    }
}
