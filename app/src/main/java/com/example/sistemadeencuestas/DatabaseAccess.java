package com.example.sistemadeencuestas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper =new DataBaseOpenHelper(context);
    }
//****************//retorno de la instancia a la base
    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    //abrir la base
    public void open(){
        this.db=openHelper.getWritableDatabase();
    }
//cerrar base
    public void close(){
        if (db!=null){
            this.db.close();
        }
    }

    public String getAddress(String name){
        c=db.rawQuery("select Address from Table1 where Name ='"+name+"'", new String[]{});
        StringBuffer buffer =new StringBuffer();
        while(c.moveToNext()){
            String address = c.getString(0);
            buffer.append(""+address);
        }
        return buffer.toString();
    }

        }



