package com.example.rafmar.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        TextView textView1 = (TextView) findViewById(R.id.miMensaje);
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton);

        Bundle myBundle = getIntent().getExtras();
        textView1.setText(myBundle.getString("TEXTO"));

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantalla2.this, pantalla1.class);
                startActivity(intent);
            }
        });

    }

    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A2: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(this, "A2: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onPause() {
        Toast.makeText(this, "A2: onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A2: onStop", Toast.LENGTH_SHORT).show();
    }
}