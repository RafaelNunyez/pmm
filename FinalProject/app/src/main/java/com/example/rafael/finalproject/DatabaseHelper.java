package com.example.rafael.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQLSentences.CREATE_TABLE_USER);
            db.execSQL(SQLSentences.CREATE_TABLE_COUNTRY);
            db.execSQL(SQLSentences.CREATE_TABLE_RELATION);
            db.execSQL(SQLSentences.FILL_USER_TABLE);
        }

        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_USER);
            db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_COUNTRY);
            db.execSQL("DROP TABLE IF EXISTS " + SQLSentences.TABLE_COUNTRY_USER_REL);
            db.execSQL(SQLSentences.CREATE_TABLE_USER);
            db.execSQL(SQLSentences.CREATE_TABLE_COUNTRY);
            db.execSQL(SQLSentences.CREATE_TABLE_RELATION);
            db.execSQL(SQLSentences.FILL_USER_TABLE);
        }

}
