package com.example.sistemadeencuestas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RespuestaConsultarActivity extends AppCompatActivity {

    EditText editIdRespuesta;
    EditText editIdIntento;
    EditText editIdOpcionesPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_respuesta_consultar);
        setContentView(R.layout.activity_respuesta_consultar);
        editIdRespuesta = (EditText) findViewById(R.id.editIdRespuestaCon);
        editIdIntento = (EditText) findViewById(R.id.editIdIntentoResCon);
        editIdOpcionesPregunta = (EditText) findViewById(R.id.editIdOpPregResCon);
    }

    public void Limpiar(View view) {
        editIdRespuesta.setText("");
        editIdIntento.setText("");
        editIdOpcionesPregunta.setText("");
    }

    public void Consultar(View view) {
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String id = editIdRespuesta.getText().toString();

        if(!id.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select * from Respuesta where idRespuesta =" +id +";", null);

            if(fila.moveToFirst()){
                editIdRespuesta.setText(fila.getString(0));
                editIdIntento.setText(fila.getString(1));
                editIdOpcionesPregunta.setText(fila.getString(2));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"Respuesta no existe ", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "se debe introducrit ID de Respuesta", Toast.LENGTH_SHORT).show();
        }
    }
}
