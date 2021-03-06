package com.example.rafmar.examenrafael;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final ImageView imagen = (ImageView) findViewById(R.id.image);
        final TextView modelo = (TextView) findViewById(R.id.modelo);
        final TextView precio = (TextView) findViewById(R.id.precio);
        final TextView extras = (TextView) findViewById(R.id.extras);
        final TextView horas = (TextView) findViewById(R.id.tiempo);
        final TextView seguro = (TextView) findViewById(R.id.seguro);
        final TextView total = (TextView) findViewById(R.id.total);

        Coches coche = (Coches) getIntent().getSerializableExtra("TODO");

        imagen.setBackground(getDrawable(coche.getImagen()));
        modelo.setText("Modelo: " + coche.getMarca() + " " + coche.getModelo());
        precio.setText("€/Hora: " + coche.getPrecio());
        extras.setText("Extras: " + String.valueOf(getIntent().getDoubleExtra("EXTRAS", 0)) + "€");
        horas.setText("Tiempo: " + getIntent().getStringExtra("HORAS") + " horas");
        seguro.setText("Seguro: " + getIntent().getStringExtra("SEGURO"));
        total.setText("Coste total: " + String.valueOf(getIntent().getDoubleExtra("PRECIO", 0)) + "€");

    }

    public void hora (View view) {
        TimePicker timePicker = new TimePicker(getApplicationContext());

        int hora = timePicker.getCurrentHour();
        int minutos = timePicker.getCurrentMinute();
        String horaActual = hora + ":" + minutos;

        Toast.makeText(getApplicationContext(), horaActual, Toast.LENGTH_LONG).show();
        
        Intent miIntent = new Intent(Pantalla2.this, MainActivity.class);

        startActivity(miIntent);
    }
}
