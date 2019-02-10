package com.example.rafael.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button newUserButton;
    Button login;

    EditText userInput;
    EditText passwordInput;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newUserButton = (Button) findViewById(R.id.newUser);
        login = (Button) findViewById(R.id.login);

        userInput = (EditText) findViewById(R.id.UserInput);
        passwordInput = (EditText) findViewById(R.id.PasswordInput);

        dbHelper = new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void login () {
        String user = userInput.getText().toString();
        String password = passwordInput.getText().toString();
        String[] userData = {user, password};
        String[] columns = {
                SQLSentences.TABLE_USER_ID,
                SQLSentences.TABLE_USER_NICKNAME,
                SQLSentences.TABLE_USER_PASSWORD
        };
        Cursor cursor;
        dbHelper.open();
        cursor = dbHelper.getItems(SQLSentences.TABLE_USER, columns, "nickname = ? AND password = ?",
        userData, SQLSentences.TABLE_USER_ID);

        if (cursor.moveToFirst()) {
            if (cursor.getString(2).equals(userInput.getText().toString())) {
                Intent intent = new Intent(this, CountriesScreen.class);

                Bundle bundle = new Bundle();
                bundle.putInt("USER", cursor.getInt(0));

                Toast.makeText(getApplicationContext(), "User: " + cursor.getString(1) + " has logged in", Toast.LENGTH_SHORT).show();

                intent.putExtras(bundle);
                startActivity(intent);
            } else
                Toast.makeText(getApplicationContext(), "Invalid user or password", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_SHORT).show();
        }

        if (!cursor.isClosed()) {
            cursor.close();
        }
        dbHelper.close();
    }

    private void createUser () {
        dbHelper.open();

        Cursor cursor = dbHelper.getItems(
                SQLSentences.TABLE_USER,
                new String[] { SQLSentences.TABLE_USER_NICKNAME },
                "nickname = ? AND password = ?",
                new String[] { userInput.getText().toString(), passwordInput.getText().toString() },
                SQLSentences.TABLE_USER_ID);

        if (cursor.moveToFirst()) {
            if (cursor.getString(0).equals(userInput.getText().toString()))
                Toast.makeText(getApplicationContext(), "User: " + userInput.getText().toString() + " is already created", Toast.LENGTH_SHORT).show();
        } else {
            dbHelper.insertItem("INSERT INTO User (nickname, password)" +
                    "VALUES ('" + userInput.getText().toString() + "', " +
                    "'" + passwordInput.getText().toString() + "')");
            Toast.makeText(getApplicationContext(), "User: " + userInput.getText().toString() + " has been created", Toast.LENGTH_SHORT).show();
        }

        dbHelper.close();
    }
}
