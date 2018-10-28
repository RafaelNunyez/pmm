package com.example.rafmar.diferentesformasdeeventos;

import android.content.Context;
import android.graphics.Color;
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
                text.setTextColor(Color.RED);
                text.setBackgroundColor(Color.GREEN);
            }
        });
    }

    public void cmdTwo_click(View view) {
        text = (TextView) this.findViewById(R.id.text);
        text.setText("Pressing Button Two");
        text.setTextColor(Color.BLUE);
        text.setBackgroundColor(Color.YELLOW);
    }

    public void Reset_click(View view) {
        text = (TextView) this.findViewById(R.id.text);
        text.setText("Changing text");
        text.setTextColor(Color.DKGRAY);
        text.setBackgroundColor(Color.WHITE);
    }
}
