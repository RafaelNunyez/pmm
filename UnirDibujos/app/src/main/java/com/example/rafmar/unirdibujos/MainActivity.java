package com.example.rafmar.unirdibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }
}

class MiDibujo extends View {

    public MiDibujo(Context c) {
        super(c);
    }

    public MiDibujo(Context c, AttributeSet a) {
        super(c, a);
    }

    protected void onDraw(Canvas canvas) {
        Paint miPincel = new Paint();
        // Color del pincel
        miPincel.setColor(Color.RED);
        // Tipo de Línea
        miPincel.setStyle(Paint.Style.STROKE);
        // Tamaño del pincel
        miPincel.setStrokeWidth(15);

        String mensaje = "(" + getWidth() + ", " + getHeight() + ")";

        int anchura = getWidth() / 2;
        int altura = getHeight() / 2;

        // Dibujo del circulo
        canvas.drawCircle(anchura, altura, 300, miPincel);
        // Dibujo del punto
        canvas.drawPoint(anchura, altura, miPincel);

        // Cambio de las propiedades del pincel
        miPincel.setStyle(Paint.Style.FILL_AND_STROKE);
        miPincel.setStrokeWidth(3);
        miPincel.setTextSize(60);
        // Escritura de un texto
        canvas.drawText(mensaje, 400, 100, miPincel);

        // Dibujo de un rectángulo
        canvas.drawRect(100, 500, 200, 600, miPincel);
        canvas.drawRect(100, 1000, 200, 1100, miPincel);
        canvas.drawRect(850, 500, 950, 600, miPincel);
        canvas.drawRect(850, 1000, 950, 1100, miPincel);
    }
}
