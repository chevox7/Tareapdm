package com.example.sistemadeencuestas;

<<<<<<< HEAD
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.Integer;
=======
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
>>>>>>> 2ee596d5b788b539645172ff24fed6113870952c

public class MateriaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_materia);
        setContentView(R.layout.activity_materia);


    }

<<<<<<< HEAD

=======
    public void Insertar(View view) {
        Intent insertar = new Intent(this, MateriaInsertarActivity.class);
        startActivity(insertar);
    }

    public void Consultar(View view) {
        Intent consultar = new Intent(this, MateriaConsultarActivity.class);
        startActivity(consultar);
    }

    public void Actualizar(View view) {
        Intent actuaizar = new Intent(this, MateriaActualizarActivity.class);
        startActivity(actuaizar);
    }

    public void Eliminar(View view) {
        Intent eliminar = new Intent(this, MateriaEliminarActivity.class);
        startActivity(eliminar);
    }

    public void Cancelar(View view) {
        Intent reg = new Intent(this, MainActivity.class);
        startActivity(reg);
    }
>>>>>>> 2ee596d5b788b539645172ff24fed6113870952c
}


