package com.example.rafael.finalproject;

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
                SQLSentences.TABLE_USER_NICKNAME,
                SQLSentences.TABLE_USER_PASSWORD
        };
        Cursor cursor;
        dbHelper.open();
        cursor = dbHelper.getItems(SQLSentences.TABLE_USER, columns, "nickname = ? AND password = ?",
        userData, SQLSentences.TABLE_USER_ID);

        if (cursor.moveToFirst()) {
            //Intent intent = new Intent(this, MainActivity.class);
            User player = new User(cursor.getString(0),
                    cursor.getString(1));
            //startActivity(intent);
            Toast.makeText(getApplicationContext(), player.getNickName(), Toast.LENGTH_SHORT).show();
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        dbHelper.close();
    }

    private void createUser () {
        dbHelper.open();
        dbHelper.insertItem("INSERT INTO User (nickname, password)" +
                "VALUES ('" + userInput.getText().toString() + "', " +
                "'" + passwordInput.getText().toString() + "')");
        dbHelper.close();
    }
}
