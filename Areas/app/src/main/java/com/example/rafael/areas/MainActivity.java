package com.example.rafael.areas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView area;
    EditText base, height;
    RadioButton circle, rectangle, triangle;
    Button draw;
    int ancho = 0, alto = 0;
    String selection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        area = (TextView) findViewById(R.id.area);

        base = (EditText) findViewById(R.id.Base);
        height = (EditText) findViewById(R.id.Height);

        circle = (RadioButton) findViewById(R.id.Circle);
        rectangle = (RadioButton) findViewById(R.id.Rectangle);
        triangle = (RadioButton) findViewById(R.id.Triangle);

        draw = (Button) findViewById(R.id.draw);

        circle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!base.getText().toString().equals(""))
                    ancho = Integer.parseInt(base.getText().toString());
                area.setText("Area = " + (Math.PI * Math.pow(ancho, 2)) + " cm²");
                selection = "circle";
            }
        });

        rectangle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!base.getText().toString().equals(""))
                    ancho = Integer.parseInt(base.getText().toString());
                if (!height.getText().toString().equals(""))
                    alto = Integer.parseInt(base.getText().toString());
                area.setText("Area = " + (ancho * alto) + " cm²");
                selection = "rectangle";
            }
        });

        triangle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!base.getText().toString().equals(""))
                    ancho = Integer.parseInt(base.getText().toString());
                if (!height.getText().toString().equals(""))
                    alto = Integer.parseInt(base.getText().toString());
                area.setText("Area = " + (ancho * alto / 2) + " cm²");
                selection = "triangle";
            }
        });
    }

    public void dibujar (View view) {
        Intent miIntent = new Intent(MainActivity.this, Figura.class);

        Bundle datos = new Bundle();

        datos.putInt("BASE", ancho);
        datos.putInt("ALTURA", alto);

        datos.putString("SELECCION", selection);

        miIntent.putExtras(datos);
        startActivity(miIntent);
    }
}
