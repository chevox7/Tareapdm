package com.example.sistemadeencuestas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaInsertarActivity extends AppCompatActivity {

    ControlBD helper;
    EditText editIdAsignatura;
    EditText editCodAsignatura;
    EditText editNomAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_materia_insertar);
        setContentView(R.layout.activity_materia_insertar);
        helper = new ControlBD(this);
        editIdAsignatura = (EditText) findViewById(R.id.editIdAsignatura);
        editCodAsignatura = (EditText) findViewById(R.id.editCodAsignatura);
        editNomAsignatura = (EditText) findViewById(R.id.editNomAsignatura);
    }

    public void Insertar(View view) {
        String IdAsignatura = editIdAsignatura.getText().toString();
        String CodAsignatura = editCodAsignatura.getText().toString();
        String NomAsignatura = editNomAsignatura.getText().toString();
        Materia mat = new Materia();
        String regInsertados;
        mat.setId(IdAsignatura);
        mat.setCodigo(CodAsignatura);
        mat.setNombre(NomAsignatura);
        helper.abrir();
        regInsertados=helper.insertar(mat);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void Limpiar(View view) {
        editIdAsignatura.setText("");
        editCodAsignatura.setText("");
        editNomAsignatura.setText("");
    }
}
