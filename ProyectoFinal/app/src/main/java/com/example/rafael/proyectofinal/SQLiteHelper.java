package com.example.rafael.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
        //fillTables(db);
    }

    @Override
    public void
    onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        deleteTables(db);
        createTables(db);
        //fillTables(db);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(SQLSentences.CREATE_TABLE_USER);
        db.execSQL(SQLSentences.CREATE_TABLE_COUNTRY);
        db.execSQL(SQLSentences.CREATE_TABLE_RELATION);
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_COUNTRY);
        db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_COUNTRY_USER_REL);
    }
}