package com.example.rafael.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper {
    private Context mCtx = null;
    private static DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    public DatabaseHelper(Context ctx) {
        this.mCtx = ctx;
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
    public DatabaseHelper open() {
        mDbHelper = new DataBaseHelperInternal(mCtx, SQLSentences.DATABASE_NAME, 4);

        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    public void close() {

        mDbHelper.close();

    }

    public Cursor getItems(String table, String[] columns, String selection, String[] selArgs,
                           String orderBy) {
        return mDb.query(table, columns, selection, selArgs, null, null, orderBy);
    }
    public long insertItem(String table, String[][] data) {
        ContentValues initialValues = new ContentValues();
        for (String[] field : data)
            initialValues.put(field[0], field[1]);
        return mDb.insert(table, null, initialValues);
    }
    public int updateItem(String table, String where, String[] whereArgs, String[][] data) {
        ContentValues contentValues = new ContentValues();
        for (String[] field : data)
            contentValues.put(field[0], field[1]);
        return mDb.update(table, contentValues, where, whereArgs);
    }
    public int delete(String table, String where, String[] whereArgs) {
        return mDb.delete(table, where, whereArgs);
    }
}
