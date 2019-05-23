package com.example.sistemadeencuestas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBD {
    private static final String[]camposAsignatura = new String [] {"idAsignatura","nomAsignatura","codAsig"};

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String BASE_DATOS = "BaseEncuesta.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE Asignatura (idAsignatura INTEGER NOT NULL, nomAsignatura TEXT NOT NULL, codAsig TEXT NOT NULL, PRIMARY KEY(idAsignatura) );");

            }catch(SQLException e){

                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }
    }
    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar(){
        DBHelper.close();
    }

    public String insertar(Materia asignatura){

        String regInsertados="Registro Insertado Nº= ";
        long contador=0;


        ContentValues asig = new ContentValues();
        asig.put("idAsignatura", asignatura.getId());
        asig.put("nomAsignatura", asignatura.getNombre());
        asig.put("codAsig", asignatura.getCodigo());
        contador=db.insert("Asignatura", null, asig);

        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
}
