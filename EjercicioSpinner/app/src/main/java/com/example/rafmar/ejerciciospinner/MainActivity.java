package com.example.rafmar.ejerciciospinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Spinner options = null;
    final static String semana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        options = (Spinner) findViewById(R.id.opt);
        final TextView text = (TextView) findViewById(R.id.text);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, semana);

        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        options.setAdapter(miAdaptador);

        options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje;
                mensaje = "Item clicked => " + semana[position];
                text.setText(mensaje);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                text.setText("");
            }
        });
    }
}
