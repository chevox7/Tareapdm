package com.example.sistemadeencuestas;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IntentoEliminarActivity extends AppCompatActivity {

    EditText editIdIntento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_intento_eliminar);
        setContentView(R.layout.activity_intento_eliminar);
        editIdIntento = (EditText) findViewById(R.id.editIdIntentoElim);
    }

    public void Eliminar(View view) {
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = editIdIntento.getText().toString();

        if(!id.isEmpty()){

            int cantidad = BaseDatabase.delete("Intento", "idIntento = " + id + ";", null);
            BaseDatabase.close();
            if(cantidad == 1){
                Toast.makeText(this, " eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el id del intento", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdIntento.setText("");

    }
}
