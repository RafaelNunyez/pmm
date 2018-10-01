package com.example.rafmar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView)findViewById(R.id.miMensaje);
        Bundle miBundle = getIntent().getExtras();
        otroSaludo.setText(miBundle.getString("TEXTO"));
    }
}
