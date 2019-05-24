package com.example.sistemadeencuestas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DocenteActivity extends AppCompatActivity {

    private EditText editText7, editText8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente);

        editText7 = (EditText)findViewById(R.id.editText2);
        editText8 = (EditText)findViewById(R.id.editText);
       // editText9 = (EditText)findViewById(R.id.editText3);


    }

    public void Ingresar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.bd",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String id = editText7.getText().toString();
        String nombre = editText8.getText().toString();
        //String codigo = editText9 .getText().toString();



        if(!id.isEmpty() && !nombre.isEmpty() /*&& !codigo.isEmpty()*/ ){
            ContentValues registro = new ContentValues();

            registro.put("idDocente", id);
            registro.put("nomDocente", nombre);

            //registro.put("codAsignatura", codigo);


            BaseDeDatos.insert("Docente", null, registro);

            BaseDeDatos.close();
            editText7.setText("");
            editText8.setText("");
            //editText9.setText("");


            Toast.makeText(this,"ingresado", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //**********Buscar*//////////
    public void Buscar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.bd",null,1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String id = editText7.getText().toString();

        if(!id.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select codAsignatura from Docente where idDocente =" +id , null);

            if(fila.moveToFirst()){
                editText7.setText(fila.getString(0));
                editText8.setText(fila.getString(1));
               // editText9.setText(fila.getString(2));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"Docente  ", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "se debe introducrit una", Toast.LENGTH_SHORT).show();
        }
    }

    //***************Eliminar*********
    public void Eliminar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.bd",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = editText7.getText().toString();

        if(!id.isEmpty()){

            int cantidad = BaseDatabase.delete("Docente", "idDocente=" + id, null);
            BaseDatabase.close();

            editText7.setText("");
            editText8.setText("");
            //editText9.setText("");

            if(cantidad == 1){
                Toast.makeText(this, " eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el id del docente", Toast.LENGTH_SHORT).show();
        }
    }

    //***********acrualizar****************


    public void Modificar(View view){
        DataBaseOpenHelper  admin = new DataBaseOpenHelper (this,"BaseEncuesta.bd",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = editText7.getText().toString();
        String nombre = editText8.getText().toString();
        //String codigo = editText9 .getText().toString();

        if(!id.isEmpty() && !nombre.isEmpty() /*&& !codigo.isEmpty()*/ ){

            ContentValues registro = new ContentValues();
            registro.put("idDocente", id);
            registro.put("nomDocente", nombre);
           // registro.put("codAsignatura", codigo);

            int cantidad = BaseDatabase.update("Docente", registro, "idDocente" + id, null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "no hay docente", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Cancelar(View view){
        Intent reg = new Intent(this, MainActivity.class);
        startActivity(reg);
    }


}
