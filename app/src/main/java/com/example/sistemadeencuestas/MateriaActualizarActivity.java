package com.example.sistemadeencuestas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaActualizarActivity extends AppCompatActivity {

    EditText editIdAsignatura;
    EditText editCodAsignatura;
    EditText editNomAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_materia_actualizar);
        setContentView(R.layout.activity_materia_actualizar);
        editIdAsignatura = (EditText) findViewById(R.id.editActIdAsignatura);
        editCodAsignatura = (EditText) findViewById(R.id.editActCodAsignatura);
        editNomAsignatura = (EditText) findViewById(R.id.editActNomAsignatura);
    }

    public void Actualizar(View view){
        DataBaseOpenHelper  admin = new DataBaseOpenHelper (this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = editIdAsignatura.getText().toString();
        String nombre = editNomAsignatura.getText().toString();
        String codigo = editCodAsignatura.getText().toString();

        if(!id.isEmpty() && !nombre.isEmpty() && !codigo.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("idAsignatura", id);
            registro.put("nomAsignatura", nombre);
            registro.put("codAsig", codigo);

            int cantidad = BaseDatabase.update("Asignatura", registro, "idAsignatura = " + id + ";", null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Asignatura no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdAsignatura.setText("");
        editCodAsignatura.setText("");
        editNomAsignatura.setText("");
    }
}
