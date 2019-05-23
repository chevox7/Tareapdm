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

public class PregActivity extends AppCompatActivity {

    private EditText et_id_tipo_area,et_id_pregunta,et_id_tipo_area_emparejamiento,et_id_area,et_tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg);

        et_id_tipo_area = (EditText)findViewById(R.id.editText2);
        et_id_pregunta = (EditText)findViewById(R.id.editText);
        et_id_tipo_area_emparejamiento = (EditText)findViewById(R.id.editText3);
        et_id_area = (EditText)findViewById(R.id.editText4);
        //et_tipo = (EditText)findViewById(R.id.editText5);

    }

    public void Registrar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this, "BaseEncuesta.bd", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String tipoa = et_id_tipo_area.getText().toString();
        String pregunta = et_id_pregunta.getText().toString();
        String tipo2 = et_id_tipo_area_emparejamiento .getText().toString();
        String area = et_id_area.getText().toString();
        //String precio = et_id_tipo_area_emparejamiento .getText().toString();

        if(!tipoa.isEmpty() && !pregunta.isEmpty() && !tipo2.isEmpty() && !area.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("idTipo_Area", tipoa);
            registro.put("idPregunta", pregunta);
            registro.put("idArea_Emparejamiento", tipo2);
            registro.put("idArea", area);

            BaseDeDatos.insert("Pregunta", null, registro);

            BaseDeDatos.close();
            et_id_tipo_area.setText("");
            et_id_pregunta.setText("");
            et_id_tipo_area_emparejamiento.setText("");
            et_id_area.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //**********Buscar*//////////
    public void Buscar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this, "BaseEncuesta.bd", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String idPregunta = et_id_pregunta.getText().toString();

        if(!idPregunta.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select  idArea from Pregunta where idPregunta =" +idPregunta , null);

            if(fila.moveToFirst()){
                et_id_area.setText(fila.getString(0));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"No hay pregunta ", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "Debes introducir pregunta", Toast.LENGTH_SHORT).show();
        }
    }

    //***************Eliminar*********
    public void Eliminar(View view){
        DataBaseOpenHelper admin = new DataBaseOpenHelper(this, "BaseEncuesta.bd", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String idPregunta = et_id_pregunta.getText().toString();

        if(!idPregunta.isEmpty()){

            int cantidad = BaseDatabase.delete("Pregunta", "id_Pregunta=" + idPregunta, null);
            BaseDatabase.close();

            et_id_tipo_area.setText("");
            et_id_pregunta.setText("");
            et_id_tipo_area_emparejamiento.setText("");
            et_id_area.setText("");

            if(cantidad == 1){
                Toast.makeText(this, " eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el id de la pregunta", Toast.LENGTH_SHORT).show();
        }
    }

    //***********acrualizar****************


    public void Modificar(View view){
        DataBaseOpenHelper  admin = new DataBaseOpenHelper (this, "BaseEncuesta.bd", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String tipoa = et_id_tipo_area.getText().toString();
        String pregunta = et_id_pregunta.getText().toString();
        String tipo2 = et_id_tipo_area_emparejamiento .getText().toString();
        String area = et_id_area.getText().toString();
        //String precio = et_id_tipo_area_emparejamiento .getText().toString();

        if(!tipoa.isEmpty() && !pregunta.isEmpty() && !tipo2.isEmpty() && !area.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("idTipo_Area", tipoa);
            registro.put("idPregunta", pregunta);
            registro.put("idArea_Emparejamiento", tipo2);
            registro.put("idArea", area);

            int cantidad = BaseDatabase.update("pregunta", registro, "idPregunta" + pregunta, null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "pregunta modificada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "no hay pregunta", Toast.LENGTH_SHORT).show();
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
