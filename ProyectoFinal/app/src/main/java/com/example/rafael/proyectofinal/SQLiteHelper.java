package com.example.rafael.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper {
    private Context myContext = null;
    private static DataBaseHelperInternal dataBaseHelperInternal = null;
    private SQLiteDatabase sqLiteDatabase = null;
    public SQLiteHelper (Context ctx) {
        this.myContext = ctx;
    }

    public SQLiteHelper open() {
        dataBaseHelperInternal = new DataBaseHelperInternal(myContext, SQLSentences.DATABASE_NAME, 4);
        sqLiteDatabase = dataBaseHelperInternal.getWritableDatabase();
        return this;
    }

    public void close() {
        dataBaseHelperInternal.close();
    }

    public Cursor getItems(String table, String[] columns, String selection, String[] selArgs, String orderBy) {
        return sqLiteDatabase.query(table, columns, selection, selArgs,null,null, orderBy);
    }

    public long insertItem (String table, String[][] data) {
        ContentValues initialValues = new ContentValues();
        for (String[] field : data) initialValues.put(field[0], field[1]);
        return sqLiteDatabase.insert(table,null, initialValues);
    }

    public int updateItem (String table, String where, String[] whereArgs, String[][] data) {
        ContentValues contentValues = new ContentValues();
        for (String[] field : data) contentValues.put(field[0], field[1]);
        return sqLiteDatabase.update(table, contentValues, where, whereArgs);
    }

    public int delete (String table, String where, String[] whereArgs) {
        return sqLiteDatabase.delete(table, where, whereArgs);
    }

    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        DataBaseHelperInternal(Context context, String databaseName, int databaseVersion) {
            super(context, databaseName, null, databaseVersion);
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

        private void fillTables (SQLiteDatabase db) {
            //TODO
            db.beginTransaction();
            try {
                db.execSQL(SQLSentences.FILL_USER_TABLE);

                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }

    }
}

