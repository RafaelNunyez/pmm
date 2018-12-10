package com.example.rafael.bicididactica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AcercaDe extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Hacemos visible la interfaz/layoutque se encuentra en acercade.xml
        setContentView(R.layout.acerca_de);
    }
}