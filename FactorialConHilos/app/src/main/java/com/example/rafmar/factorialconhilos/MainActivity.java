package com.example.rafmar.factorialconhilos;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText miTexto;
    private TextView miVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTexto = (EditText) findViewById(R.id.myText);
        miVista = (TextView) findViewById(R.id.myView);
    }

    public void calcularOperación (View v) {
        int n = Integer.parseInt(miTexto.getText().toString());
        miVista.append(n + " != ");
        MiThread thread = new MiThread(n);
        thread.start();
    }

    public int factorial (int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            SystemClock.sleep(1000);
        }
        return res;
    }

    class MiThread extends Thread {
        private int n, res;
        public MiThread (int n) {
            this.n = n;
        }

        public void run() {
            res = factorial(n);
            //miVista.append(String.valueOf(res));

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    miVista.append(res + "\n");
                }
            });
        }
    }

}

