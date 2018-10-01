package com.example.rafmar.ejemploradiobutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.texto);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.group);
        final RadioButton red = (RadioButton)findViewById(R.id.red);
        final RadioButton blue = (RadioButton)findViewById(R.id.blue);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                text.setText("ID opción seleccionada: " + checkedId);

                if (red.isChecked())
                    text.setTextColor(Color.RED);
                if (blue.isChecked())
                    text.setTextColor(Color.BLUE);

            }
        });
    }
}