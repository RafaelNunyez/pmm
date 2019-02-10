package com.example.rafael.proyectofinal;

public final class SQLSentences {
    public static final String DATABASE_NAME = "Countries";

    public static final String TABLE_USER = "User";
    public static final String TABLE_USER_ID = "id";
    public static final String TABLE_USER_NICKNAME = "nickname";
    public static final String TABLE_USER_PASSWORD = "password";

    public static final String TABLE_COUNTRY = "Country";
    public static final String TABLE_COUNTRY_ID = "id";
    public static final String TABLE_COUNTRY_NAME = "name";

    public static final String TABLE_COUNTRY_USER_REL = "Country_User_Rel";
    public static final String TABLE_COUNTRY_USER_REL_ID = "id";
    public static final String TABLE_COUNTRY_USER_REL_USER_ID = "user_id";
    public static final String TABLE_COUNTRY_USER_REL_COUNTRY_ID = "country_id";

    public static final String CREATE_TABLE_USER = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL) ",
            TABLE_USER,
            TABLE_USER_ID,
            TABLE_USER_NICKNAME,
            TABLE_USER_PASSWORD
    );

    public static final String CREATE_TABLE_COUNTRY = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL)",
            TABLE_COUNTRY,
            TABLE_COUNTRY_ID,
            TABLE_COUNTRY_NAME
    );

    public static final String CREATE_TABLE_RELATION = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s) " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s) ",

            TABLE_COUNTRY_USER_REL,
            TABLE_COUNTRY_USER_REL_ID,
            TABLE_COUNTRY_USER_REL_USER_ID,
            TABLE_USER,
            TABLE_USER_ID,
            TABLE_COUNTRY_USER_REL_COUNTRY_ID,
            TABLE_COUNTRY,
            TABLE_COUNTRY_ID
    );

    //Filling Tables
    public static final String FILL_USER_TABLE = String.format(
            "INSERT INTO %s VALUES(%s, %s)",
            TABLE_USER,
            "Admin",
            "Admin"
    );
}
