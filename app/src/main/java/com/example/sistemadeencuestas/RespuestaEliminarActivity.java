package com.example.sistemadeencuestas;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RespuestaEliminarActivity extends AppCompatActivity {

    EditText editIdRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_respuesta_eliminar);
        setContentView(R.layout.activity_respuesta_eliminar);
        editIdRespuesta = (EditText) findViewById(R.id.editIdRespuestaElim);
    }

    public void Eliminar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = editIdRespuesta.getText().toString();

        if(!id.isEmpty()){

            int cantidad = BaseDatabase.delete("Respuesta", "idRespuesta = " + id + ";", null);
            BaseDatabase.close();
            if(cantidad == 1){
                Toast.makeText(this, " eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el id de la respuesta", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdRespuesta.setText("");
    }
}
