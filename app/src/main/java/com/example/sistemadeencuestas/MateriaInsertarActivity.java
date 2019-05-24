package com.example.sistemadeencuestas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaInsertarActivity extends AppCompatActivity {

    EditText editIdAsignatura;
    EditText editCodAsignatura;
    EditText editNomAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_materia_insertar);
        setContentView(R.layout.activity_materia_insertar);
        editIdAsignatura = (EditText) findViewById(R.id.editIdAsignatura);
        editCodAsignatura = (EditText) findViewById(R.id.editCodAsignatura);
        editNomAsignatura = (EditText) findViewById(R.id.editNomAsignatura);
    }

    public void Insertar(View view) {
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String id = editIdAsignatura.getText().toString();
        String nombre = editNomAsignatura.getText().toString();
        String codigo = editCodAsignatura .getText().toString();



        if(!id.isEmpty() && !nombre.isEmpty() && !codigo.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("idAsignatura", id);
            registro.put("nomAsignatura", nombre);
            registro.put("codAsig", codigo);


            BaseDeDatos.insert("Asignatura", null, registro);

            Toast.makeText(this,"ingresado", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdAsignatura.setText("");
        editCodAsignatura.setText("");
        editNomAsignatura.setText("");
    }
}
