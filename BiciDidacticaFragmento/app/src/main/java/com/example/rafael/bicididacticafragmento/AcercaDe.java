package com.example.rafael.bicididacticafragmento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class AcercaDe extends AppCompatActivity {
    View miFragmento;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Hacemos visible la interfaz/layoutque se encuentra en acercade.xml
        setContentView(R.layout.acerca_de);

        miFragmento = (View) findViewById(R.id.ejemplo);
        miFragmento.setVisibility(View.VISIBLE);
    }
}