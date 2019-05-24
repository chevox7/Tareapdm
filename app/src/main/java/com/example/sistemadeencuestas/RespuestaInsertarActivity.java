package com.example.sistemadeencuestas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RespuestaInsertarActivity extends AppCompatActivity {

    EditText editIdRespuesta;
    EditText editIdIntento;
    EditText editIdOpcionesPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_respuesta_insertar);
        setContentView(R.layout.activity_respuesta_insertar);
        editIdRespuesta = (EditText) findViewById(R.id.editIdRespuestaIns);
        editIdIntento = (EditText) findViewById(R.id.editIdIntentoResIns);
        editIdOpcionesPregunta = (EditText) findViewById(R.id.editIdOpPregResIns);
    }

    public void Insertar(View view) {
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String id = editIdRespuesta.getText().toString();
        String intento = editIdIntento.getText().toString();
        String opciones = editIdOpcionesPregunta.getText().toString();



        if(!id.isEmpty() && !intento.isEmpty() && !opciones.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("idRespuesta", id);
            registro.put("idIntento", intento);
            registro.put("idOpciones_Pregunta", opciones);


            BaseDeDatos.insert("Respuesta", null, registro);

            Toast.makeText(this,"ingresado", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdRespuesta.setText("");
        editIdIntento.setText("");
        editIdOpcionesPregunta.setText("");
    }
}
