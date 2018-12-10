package com.example.rafmar.fragmentobasico;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    View miFragmento;
    CheckBox apareceFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miFragmento = (View) findViewById(R.id.ejemplo);
        apareceFrag = (CheckBox) findViewById(R.id.checkFrag);

        apareceFrag.setChecked(true);

        apareceFrag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (apareceFrag.isChecked()) miFragmento.setVisibility(View.VISIBLE);
                else miFragmento.setVisibility(View.INVISIBLE);
            }
        });
    }
}
