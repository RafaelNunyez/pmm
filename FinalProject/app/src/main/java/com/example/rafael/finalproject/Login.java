package com.example.rafael.finalproject;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.app.DialogFragment;
import android.database.sqlite.SQLiteDatabase;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newUserButton = (Button) findViewById(R.id.newUser);
        login = (Button) findViewById(R.id.login);

        userInput = (EditText) findViewById(R.id.UserInput);
        passwordInput = (EditText) findViewById(R.id.PasswordInput);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogNewUser();
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
        if(!user.isEmpty() && !password.isEmpty()){
            DatabaseHelper admin= new DatabaseHelper(this, SQLSentences.DATABASE_NAME,null,1);
            SQLiteDatabase BaseDatos= admin.getWritableDatabase();

            Cursor cursor = BaseDatos.rawQuery("SELECT nickname, password from User where Nombre = '" + user + "';", null);
            if(cursor.moveToFirst()){
                //Intent cambio= new Intent(Login.this, MenuPrincipalCompras.class);
                //startActivity(cambio);
                Toast.makeText(getApplicationContext(), cursor.getColumnIndex("nickname"),Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"ACCESO DENEGADO\nUSUARIO O CONTRASEÑA INCORRECTOS",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Rellena todos los campos",Toast.LENGTH_SHORT).show();
        }
    }

    void showDialogNewUser () {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("newUserButton");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = newUser.newInstance();
        dialogFragment.show(ft,"newUserButton");
    }
}
