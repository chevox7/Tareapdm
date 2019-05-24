package com.example.sistemadeencuestas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaConsultarActivity extends AppCompatActivity {

    EditText editIdAsignatura;
    EditText editCodAsignatura;
    EditText editNomAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.tittle_activity_materia_consultar);
        setContentView(R.layout.activity_materia_consultar);
        editIdAsignatura = (EditText) findViewById(R.id.editConIdAsignatura);
        editCodAsignatura = (EditText) findViewById(R.id.editConCodAsignatura);
        editNomAsignatura = (EditText) findViewById(R.id.editConNomAsignatura);
    }

    public void Consultar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.db",null,1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String id = editIdAsignatura.getText().toString();

        if(!id.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select * from Asignatura where idAsignatura =" +id +";", null);

            if(fila.moveToFirst()){
                editIdAsignatura.setText(fila.getString(0));
                editNomAsignatura.setText(fila.getString(1));
                editCodAsignatura.setText(fila.getString(2));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"Asignatura  ", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "se debe introducrit un ID", Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(View view) {
        editIdAsignatura.setText("");
        editCodAsignatura.setText("");
        editNomAsignatura.setText("");
    }
}
