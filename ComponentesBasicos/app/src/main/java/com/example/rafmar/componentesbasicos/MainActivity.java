package com.example.rafmar.componentesbasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    CheckBox chkCycling;
    CheckBox chkTeaching;
    CheckBox chkBlogging;
    Button btnHobby;
    TextView txtHobby;
    String message = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        //btnHobby = (Button) findViewById(R.id.btnHobby);
        txtHobby = (TextView) findViewById(R.id.mensaje);

        chkBlogging.setOnCheckedChangeListener(new Checks());
        chkCycling.setOnCheckedChangeListener(new Checks());
        chkTeaching.setOnCheckedChangeListener(new Checks());

        /*chkBlogging.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkBlogging.isChecked())
                    message = "Blogging ";
            }
        });

        chkCycling.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkCycling.isChecked())
                    message = "Cycling ";
            }
        });

        chkTeaching.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkTeaching.isChecked())
                    message = "Teaching ";
            }
        });*/

    } //If text below this uncommented, delete this row
        /*btnHobby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getHobbyClick(v);
            }
        });
    }

    public void getHobbyClick(View v) {
        String strMessage = "";
        if(chkCycling.isChecked()) {
            strMessage += "Cycling ";
        }
        if(chkTeaching.isChecked()) {
            strMessage += "Teaching ";
        }
        if(chkBlogging.isChecked()) {
            strMessage += "Blogging ";
        }
        txtHobby.setText(strMessage);
    }*/

    //New Class
    class Checks implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged (CompoundButton button, boolean checked) {
            message = "";
            if (checked) {
                if (button == chkBlogging)
                    message += "Blogging ";
                if (button == chkCycling)
                    message += "Cycling ";
                if (button == chkTeaching)
                    message += "Teaching ";
            }
            txtHobby.setText(message);
        }
    }
}