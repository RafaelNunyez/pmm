package com.example.rafael.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button newUser;
    Button login;

    EditText userInput;
    EditText passwordInput;

    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newUser = (Button) findViewById(R.id.newUser);
        login = (Button) findViewById(R.id.login);

        userInput = (EditText) findViewById(R.id.UserInput);
        passwordInput = (EditText) findViewById(R.id.PasswordInput);

        dbHelper = new DatabaseHelper(this, 4);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login();
            }
        });


    }

    private void login() {
        SQLiteDatabase bd = dbHelper.getWritableDatabase();
        /*String user = userInput.getText().toString();
        String password = passwordInput.getText().toString();
        String[] userData = {user, password};
        String[] columns = {
                SQLSentences.TABLE_USER_NICKNAME,
                SQLSentences.TABLE_USER_PASSWORD
        };*/
        Cursor cursor;
        cursor = dbHelper.getItems(SQLSentences.TABLE_USER,
                new String[]{userInput.getText().toString(), passwordInput.getText().toString()},
                "name = ? AND password = ?",
                new String[]{SQLSentences.TABLE_USER_NICKNAME,SQLSentences.TABLE_USER_PASSWORD},
                SQLSentences.TABLE_USER_ID);
        if (cursor.moveToFirst()) {
            Toast.makeText(getApplicationContext(), cursor.getString(0), Toast.LENGTH_SHORT).show();
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        bd.close();
    }
}
