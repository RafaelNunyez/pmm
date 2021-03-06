package com.example.rafael.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper {
    private Context myContext;
    private static DataBaseHelperInternal dataBaseHelperInternal;
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(Context ctx) {
        this.myContext = ctx;
    }

    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        DataBaseHelperInternal (Context context, String databaseName, int databaseVersion) {
            super(context, databaseName, null, databaseVersion);
        }

        public void onCreate(SQLiteDatabase db) {
            createTables(db);
            fillTables(db);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
            fillTables(db);
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

        private void fillTables(SQLiteDatabase db) {
            db.beginTransaction();
            try {
                db.execSQL(SQLSentences.FILL_USER_TABLE);
                db.execSQL(SQLSentences.FILL_COUNTRY_TABLE);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
    }

    public DatabaseHelper open() {
        dataBaseHelperInternal = new DataBaseHelperInternal(myContext, SQLSentences.DATABASE_NAME, 4);

        sqLiteDatabase = dataBaseHelperInternal.getWritableDatabase();

        return this;
    }

    public void close() { dataBaseHelperInternal.close(); }

    public Cursor getItems (String table, String[] columns, String selection, String[] selArgs, String orderBy) {
        return sqLiteDatabase.query(table, columns, selection, selArgs,null,null, orderBy);
    }

    public void insertItem (String query) {
        sqLiteDatabase.execSQL(query);
    }
}
