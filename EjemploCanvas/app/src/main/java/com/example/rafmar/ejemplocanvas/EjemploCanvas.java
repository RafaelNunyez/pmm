package com.example.rafmar.ejemplocanvas;

import android.content.*;
import android.graphics.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

public class EjemploCanvas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView (Context context) {
            super(context);
        }

        @Override
        protected void onDraw (Canvas canvas) {
            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);
            for (int i = 0; i < 500; i++)
                canvas.drawCircle(150, 150, 80 * i, pincel);
        }
    }
}
