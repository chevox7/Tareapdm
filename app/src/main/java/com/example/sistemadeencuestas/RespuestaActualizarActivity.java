package com.example.sistemadeencuestas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RespuestaActualizarActivity extends AppCompatActivity {

    EditText editIdRespuesta;
    EditText editIdIntento;
    EditText editIdOpcionesPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_respuesta_actualizar);
        setContentView(R.layout.activity_respuesta_actualizar);
        editIdRespuesta = (EditText) findViewById(R.id.editIdRespuestaAct);
        editIdIntento = (EditText) findViewById(R.id.editIdIntentoResAct);
        editIdOpcionesPregunta = (EditText) findViewById(R.id.editIdOpPregResAct);
    }

    public void Actualizar(View view){
        DataBaseOpenHelper  admin = new DataBaseOpenHelper (this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = editIdRespuesta.getText().toString();
        String intento = editIdIntento.getText().toString();
        String opciones = editIdOpcionesPregunta.getText().toString();

        if(!id.isEmpty() && !intento.isEmpty() && !opciones.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("idRespuesta", id);
            registro.put("idIntento", intento);
            registro.put("idOpciones_Pregunta", opciones);

            int cantidad = BaseDatabase.update("Respuesta", registro, "idRespuesta = " + id + ";", null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Respuesta no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdRespuesta.setText("");
        editIdIntento.setText("");
        editIdOpcionesPregunta.setText("");
    }
}
