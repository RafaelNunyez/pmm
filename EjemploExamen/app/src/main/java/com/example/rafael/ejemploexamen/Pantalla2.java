package com.example.rafael.ejemploexamen;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final ImageView mapa = (ImageView) findViewById(R.id.image);
        final TextView zona = (TextView) findViewById(R.id.zona);
        final TextView tarifa = (TextView) findViewById(R.id.tarifa);
        final TextView peso = (TextView) findViewById(R.id.peso);
        final TextView deco = (TextView) findViewById(R.id.deco);
        final TextView total = (TextView) findViewById(R.id.total);

        Zonas zonas = (Zonas) getIntent().getSerializableExtra("TODO");
        if (zonas.getZona().equals("Zona A"))
            mapa.setImageDrawable(getDrawable(R.drawable.asiaoce));
        if (zonas.getZona().equals("Zona B"))
            mapa.setImageDrawable(getDrawable(R.drawable.ameafr));
        if (zonas.getZona().equals("Zona C"))
            mapa.setImageDrawable(getDrawable(R.drawable.europa));
        zona.setText(zonas.getZona());
        tarifa.setText("Tarifa: " + getIntent().getStringExtra("TARIFA"));
        peso.setText("Peso: " + getIntent().getDoubleExtra("PESO", 0));
        deco.setText("Decoración: " + getIntent().getStringExtra("DECO"));
        total.setText("Precio total del envío: " + String.valueOf(getIntent().getDoubleExtra("PRECIO", 0)) + "€");

        registerForContextMenu(mapa);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_image, menu);

        return true;
    }

    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_image, menu);
    }

}
