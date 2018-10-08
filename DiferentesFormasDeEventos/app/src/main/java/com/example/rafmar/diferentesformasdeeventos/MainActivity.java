package com.example.rafmar.diferentesformasdeeventos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Context ctx=null;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx=this;
        text = (TextView) this.findViewById(R.id.text);
        setContentView(R.layout.activity_main);
        Button btn = (Button) this.findViewById(R.id.cmdThree);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                text.setText("Pressing Button Three");
            }
        });
    }

    public void cmdTwo_click(View view) {
        text = (TextView) this.findViewById(R.id.text);
        text.setText("Pressing Button Two");
    }
}
