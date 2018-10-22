package com.example.rafmar.ejerciciolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView title = (TextView) findViewById(R.id.titulo);
        final TextView subtitle = (TextView) findViewById(R.id.subtitulo);

        Titular titular = (Titular) getIntent().getSerializableExtra("TODO");
        title.setText(titular.getTitulo());
        subtitle.setText(titular.getSubtitulo());
    }
}
