package com.example.rafael.ejemploexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView zona = (TextView) findViewById(R.id.zona);
        final TextView tarifa = (TextView) findViewById(R.id.tarifa);
        final TextView peso = (TextView) findViewById(R.id.peso);
        final TextView deco = (TextView) findViewById(R.id.deco);
        final TextView total = (TextView) findViewById(R.id.total);

        Zonas zonas = (Zonas) getIntent().getSerializableExtra("TODO");
        zona.setText(zonas.getZona());
        tarifa.setText("asdf");
        peso.setText("");
        deco.setText("");
        total.setText(String.valueOf(getIntent().getDoubleExtra("TOTAL", 0)));
    }
}
