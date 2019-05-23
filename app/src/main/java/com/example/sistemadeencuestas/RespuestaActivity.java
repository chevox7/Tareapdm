package com.example.sistemadeencuestas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RespuestaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_respuesta);
        setContentView(R.layout.activity_respuesta);
    }

    public void Insertar(View view) {
        Intent insertar = new Intent(this, RespuestaInsertarActivity.class);
        startActivity(insertar);
    }

    public void Consultar(View view) {
        Intent consultar = new Intent(this, RespuestaConsultarActivity.class);
        startActivity(consultar);
    }

    public void Actualizar(View view) {
        Intent actuaizar = new Intent(this, RespuestaActualizarActivity.class);
        startActivity(actuaizar);
    }

    public void Eliminar(View view) {
        Intent eliminar = new Intent(this, RespuestaEliminarActivity.class);
        startActivity(eliminar);
    }

    public void Cancelar(View view) {
        Intent reg = new Intent(this, MainActivity.class);
        startActivity(reg);
    }
}
