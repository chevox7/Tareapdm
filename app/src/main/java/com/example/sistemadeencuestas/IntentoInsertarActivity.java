package com.example.sistemadeencuestas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IntentoInsertarActivity extends AppCompatActivity {

    EditText editIdIntento;
    EditText editIdAlumno;
    EditText editIdClave;
    EditText editIdEncuestado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_intento_insertar);
        setContentView(R.layout.activity_intento_insertar);
        editIdIntento = (EditText) findViewById(R.id.editIdIntentoIns);
        editIdAlumno = (EditText) findViewById(R.id.editIdAlumnoInIns);
        editIdClave = (EditText) findViewById(R.id.editIdClaveInIns);
        editIdEncuestado = (EditText) findViewById(R.id.editIdEncuestadoInIns);
    }

    public void Insertar(View view) {
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String id = editIdIntento.getText().toString();
        String alumno = editIdAlumno.getText().toString();
        String clave = editIdClave.getText().toString();
        String encuestado = editIdEncuestado.getText().toString();


        if(!id.isEmpty() && !alumno.isEmpty() && !clave.isEmpty() && !encuestado.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("idIntento", id);
            registro.put("idAlumno", alumno);
            registro.put("idClave", clave);
            registro.put("idEncuestado",encuestado);

            BaseDeDatos.insert("Intento", null, registro);

            Toast.makeText(this,"ingresado", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdIntento.setText("");
        editIdAlumno.setText("");
        editIdClave.setText("");
        editIdEncuestado.setText("");
    }
}
