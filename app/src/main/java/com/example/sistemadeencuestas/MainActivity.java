package com.example.sistemadeencuestas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CrearEncuesta(View view){
        Intent crear = new Intent(this, CrearEncuestaActivity.class);
        startActivity(crear);
    }

    public void ResponderEncuesta(View view){
        Intent responder = new Intent(this, RespEncActivity.class);
        startActivity(responder);
    }

    public void Lista(View view){
        Intent list = new Intent(this, ListaEncActivity.class);
        startActivity(list);
    }

}
