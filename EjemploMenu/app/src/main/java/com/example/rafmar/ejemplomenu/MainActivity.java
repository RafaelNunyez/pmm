package com.example.rafmar.ejemplomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mensaje;
    private ImageView imagen;
    private View vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensaje = (TextView) findViewById(R.id.mensaje);
        imagen = (ImageView) findViewById(R.id.image);
        vista = (View) findViewById(R.id.drawing_Area);

        registerForContextMenu(vista);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                mensaje.setText("Opción 1 Pulsada");
                return true;
            case R.id.MnuOpc2:
                mensaje.setText("Opción 2 Pulsada");
                return true;
            case R.id.MnuOpc3:
                mensaje.setText("Opción 3 Pulsada");
                return true;
            case R.id.SubItem1:
                mensaje.setText("SubItem 1 Pulsada");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_image, menu);
    }
}
