package com.example.rafael.proyectofinal;

import android.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements NewUser.OnInputListener {

    final ArrayList arrayList1 = new ArrayList();
    final ArrayList arrayList2 = new ArrayList();
    SQLiteHelper sqLiteHelper;
    SQLiteDatabase bd;

    EditText userInput = null;
    EditText passwordInput = null;

    Cursor cursor2;

    @Override
    public void sendInput(ArrayList arrayList) {
        bd.execSQL("INSERT INTO Users (nickName, password) " +
                "VALUES ('" + arrayList.get(0) + "', '" + arrayList.get(1) + "')");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button newUser = (Button) findViewById(R.id.newUser);
        Button login = (Button) findViewById(R.id.login);
        userInput = (EditText) findViewById(R.id.UserInput);
        passwordInput = (EditText) findViewById(R.id.PasswordInput);

        sqLiteHelper = new SQLiteHelper(this);

        cursor2 = bd.rawQuery("SELECT nickName FROM Users",null);

        if(cursor2 != null) {
            if (cursor2.moveToFirst()) {
                String user = "";
                do {
                    user = cursor2.getString(0);
                    arrayList2.add(user);
                } while (cursor2.moveToNext());
                cursor2.close();
            }
        }

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteHelper.open();
                String user = "";
                String password = "";

                cursor2 = bd.rawQuery("SELECT nickName FROM Users",null);

                if(cursor2.moveToFirst()){
                    do{
                        user = cursor2.getString(0);
                        arrayList1.add(user);
                        Toast.makeText(getApplicationContext(), "Usuario: " + user, Toast.LENGTH_SHORT).show();
                    }while(cursor2.moveToNext());
                    cursor2.close();
                }
                boolean checker = false;
                for(int i = 0; i < arrayList1.size(); i++){
                    if(((String) arrayList1.get(i)).equalsIgnoreCase(userInput.getText().toString())){
                        checker = true;
                    }
                }
                if(checker){
                    User userRegistered = new User(userInput.getText().toString(), passwordInput.getText().toString());
                    Toast.makeText(getApplicationContext(), "Login succeed",Toast.LENGTH_LONG).toString();
                    Intent intent = new Intent(Login.this, null); //Pantalla 3
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("UserRegistered", userRegistered);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Login failed",Toast.LENGTH_LONG).show();
                    passwordInput.setText("");
                }

                sqLiteHelper.close();
            }
        });
    }
    
    void showDialog() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("NewUser");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = NewUser.newInstance(arrayList2);
        dialogFragment.show(ft,"NewUser");
    }
}