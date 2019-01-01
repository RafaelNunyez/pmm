package com.example.rafael.doblespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View fragmentoSpinner;
    View fragmentoDesc;

    public static String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentoSpinner = (View) findViewById(R.id.spinner);
        fragmentoSpinner.setVisibility(View.VISIBLE);

        fragmentoDesc = (View) findViewById(R.id.description);
        fragmentoDesc.setVisibility(View.VISIBLE);
    }
}
