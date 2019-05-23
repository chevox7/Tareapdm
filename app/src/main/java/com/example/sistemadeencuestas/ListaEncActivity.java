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

public class ListaEncActivity extends AppCompatActivity {

    private EditText idEncuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_enc);

        idEncuesta = (EditText)findViewById(R.id.editText6);

}

    public void Registrar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.bd",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String enc = idEncuesta.getText().toString();
        //String pregunta = et_id_pregunta.getText().toString();
        //String tipo2 = et_id_tipo_area_emparejamiento .getText().toString();
        //String area = et_id_area.getText().toString();
        //String precio = et_id_tipo_area_emparejamiento .getText().toString();

        if(!enc.isEmpty() /*&& !pregunta.isEmpty() && !tipo2.isEmpty() && !area.isEmpty()*/){
            ContentValues registro = new ContentValues();

            registro.put("idEncuesta", enc);
            //registro.put("idPregunta", pregunta);
            //registro.put("idArea_Emparejamiento", tipo2);
            //registro.put("idArea", area);

            BaseDeDatos.insert("Encuesta", null, registro);

            BaseDeDatos.close();
            idEncuesta.setText("");
           // et_id_pregunta.setText("");
           // et_id_tipo_area_emparejamiento.setText("");
            //et_id_area.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //**********Buscar*//////////
    public void Buscar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.bd",null,1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();


        String enc = idEncuesta.getText().toString();

        if (!enc.isEmpty()) {
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select  idEncuesta from Encuesta where idEncuesta =" +enc , null);

            if(fila.moveToFirst()){
                idEncuesta.setText(fila.getString(0));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"ninguna encuesta ", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "debe introducir alguna encuesta", Toast.LENGTH_SHORT).show();
        }
    }

    //***************Eliminar*********
    public void Eliminar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this,"BaseEncuesta.bd",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String enc = idEncuesta.getText().toString();

        if(!enc.isEmpty()){

            int cantidad = BaseDatabase.delete("Encuesta", "idPregunta=" + enc, null);
            BaseDatabase.close();

            idEncuesta.setText("");
            //et_id_pregunta.setText("");
            //et_id_tipo_area_emparejamiento.setText("");
            //et_id_area.setText("");

            if(cantidad == 1){
                Toast.makeText(this, " eliminada exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el id de la encuesta", Toast.LENGTH_SHORT).show();
        }
    }

    //***********acrualizar****************


    public void Modificar(View view){
        DataBaseOpenHelper  admin = new DataBaseOpenHelper (this,"BaseEncuesta.bd",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String enc = idEncuesta.getText().toString();
       // String pregunta = et_id_pregunta.getText().toString();
        //String tipo2 = et_id_tipo_area_emparejamiento .getText().toString();
        //String area = et_id_area.getText().toString();
        //String precio = et_id_tipo_area_emparejamiento .getText().toString();

        if(!enc.isEmpty()/* && !pregunta.isEmpty() && !tipo2.isEmpty() && !area.isEmpty()*/){

            ContentValues registro = new ContentValues();
            registro.put("idEncuesta", enc);
            //registro.put("idPregunta", pregunta);
           // registro.put("idArea_Emparejamiento", tipo2);
            //registro.put("idArea", area);

            int cantidad = BaseDatabase.update("Encuesta", registro, "idEncuesta" + enc, null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, " modificado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "no hay valido", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    public void Regresar1(View view){
        Intent reg = new Intent(this, MainActivity.class);
        startActivity(reg);
    }
}
