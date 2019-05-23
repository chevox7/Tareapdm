package com.example.sistemadeencuestas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_intento);
        setContentView(R.layout.activity_intento);
    }

    public void Insertar(View view) {
        Intent insertar = new Intent(this, IntentoInsertarActivity.class);
        startActivity(insertar);
    }

    public void Consultar(View view) {
        Intent consultart = new Intent(this, IntentoConsultarActivity.class);
        startActivity(consultart);
    }

    public void Actualizar(View view) {
        Intent actuaizar = new Intent(this, IntentoActualizarActivity.class);
        startActivity(actuaizar);
    }

    public void Eliminar(View view) {
        Intent eliminar = new Intent(this, IntentoEliminarActivity.class);
        startActivity(eliminar);
    }

    public void Cancelar(View view) {
        Intent reg = new Intent(this, MainActivity.class);
        startActivity(reg);
    }
}
