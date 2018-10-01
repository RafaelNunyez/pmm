package com.example.rafmar.factorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView1 = (TextView) findViewById(R.id.myView);

        Bundle myBundle = getIntent().getExtras();
        textView1.setText(myBundle.getString("TEXTO"));
    }
}
