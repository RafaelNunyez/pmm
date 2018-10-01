package com.example.rafmar.factorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText miTexto;
    private Button miBoton;
    private TextView miVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTexto = (EditText) findViewById(R.id.myText);
        miBoton = (Button) findViewById(R.id.myButton);
        miVista = (TextView) findViewById(R.id.myView);

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("TEXTO", calculate());
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
    }

    public String calculate () {
        int n = Integer.parseInt(miTexto.getText().toString());
        double res = factorial(n);
        String result = n + " != " + Double.toString(res);
        return result;
    }

    public double factorial (int n) {
        double res = n;
        for (int i = 2; i < n; i++)
            res *= i;
        return res;
    }
}
