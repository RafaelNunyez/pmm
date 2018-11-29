package com.example.rafmar.factorialasyntask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText miTexto;
    private TextView miVista;
    private Button miBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTexto = (EditText) findViewById(R.id.myText);
        miVista = (TextView) findViewById(R.id.myView);
        miBoton = (Button) findViewById(R.id.myButton);

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcularOperación();
            }
        });
    }

    public void calcularOperación () {
        int n = Integer.parseInt(miTexto.getText().toString());
        miVista.append(n + " != ");
        MiTarea tarea = new MiTarea();
        tarea.execute(n);
    }

    public int factorial (int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            SystemClock.sleep(1000);
        }
        return res;
    }

    class MiTarea extends AsyncTask<Integer, Void, Integer> {
        @Override
        protected Integer doInBackground (Integer... n) {
            return factorial(n[0]);
        }

        @Override
        protected void onPostExecute (Integer res) {
            miVista.append(res + "\n");
        }
    }

}

