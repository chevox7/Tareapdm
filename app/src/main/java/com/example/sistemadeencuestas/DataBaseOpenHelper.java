package com.example.sistemadeencuestas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.health.PackageHealthStats;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DataBaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME="BaseEncuesta.db";
    private static final int DATABASE_VERSION = 1;


    public DataBaseOpenHelper(Context context, String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }






}
