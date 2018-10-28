package com.example.rafmar.diferentesformasdeeventos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class MyButton extends android.support.v7.widget.AppCompatButton implements View.OnClickListener {
    Context ctx;
    TextView text;

    public MyButton(Context context) {
        super(context);
        ctx = context;
        this.setOnClickListener(this);//recoger evento
    }

    //cuando se cree desde un recurso XML
    public MyButton(Context context, AttributeSet attr) {
        super(context,attr);
        ctx = context;
        this.setOnClickListener(this);
    }

    //cuando se cree desde un recurso XML
    public MyButton(Context context, AttributeSet attr, int defaultStyles) {
        super(context, attr, defaultStyles);
        ctx = context;
        this.setOnClickListener(this);
    }
    @Override
    public void onClick (View v) {
        text = (TextView) ((Activity) ctx).findViewById(R.id.text);
        text.setText("Pressing Button One");
        text.setTextColor(Color.MAGENTA);
        text.setBackgroundColor(Color.BLACK);
    }
}