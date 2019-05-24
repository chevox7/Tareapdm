package com.example.sistemadeencuestas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IntentoConsultarActivity extends AppCompatActivity {

    EditText editIdIntento;
    EditText editIdAlumno;
    EditText editIdClave;
    EditText editIdEncuestado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_intento_consultar);
        setContentView(R.layout.activity_intento_consultar);
        editIdIntento = (EditText) findViewById(R.id.editIdIntentoCon);
        editIdAlumno = (EditText) findViewById(R.id.editIdAlumnoInCon);
        editIdClave = (EditText) findViewById(R.id.editIdClaveInCon);
        editIdEncuestado = (EditText) findViewById(R.id.editIdEncuestadoInCon);
    }

    public void Consultar(View view) {
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String id = editIdIntento.getText().toString();

        if(!id.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select * from Intento where idIntento =" +id +";", null);

            if(fila.moveToFirst()){
                editIdIntento.setText(fila.getString(0));
                editIdAlumno.setText(fila.getString(1));
                editIdClave.setText(fila.getString(2));
                editIdEncuestado.setText(fila.getString(3));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"Intento no existe", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "se debe introducrit ID de Intento", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdIntento.setText("");
        editIdAlumno.setText("");
        editIdClave.setText("");
        editIdEncuestado.setText("");
    }
}
