package com.example.rafael.ejemploexamen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int precioZona;
    private static double precioKilo;
    private static EditText peso;
    private static RadioButton normal;
    private static RadioButton urgente;
    private static TextView eleccion;
    private static CheckBox caja;
    private static CheckBox tarjeta;
    private double total;
    private Zonas zone;

    private Zonas[] datos = new Zonas[] {
            new Zonas (0, "Zona A", "Asía y Oceanía", "30€"),
            new Zonas (1, "Zona B", "América y Áfríca", "20€"),
            new Zonas (2, "Zona C", "Europa", "10€")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorZonas adaptador = new AdaptadorZonas(this);
        ListView lstOpciones = (ListView) findViewById(R.id.opciones);
        lstOpciones.setAdapter(adaptador);
        eleccion = (TextView) findViewById(R.id.eleccion);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView arg0, View arg1, int position, long id) {
                if (position == 0) {
                    precioZona = 30;
                    eleccion.setText("Zona Elegida: " + datos[position].getZona());
                }
                if (position == 1) {
                    precioZona = 20;
                    eleccion.setText("Zona Elegida: " + datos[position].getZona());
                }
                if (position == 2) {
                    precioZona = 10;
                    eleccion.setText("Zona Elegida: " + datos[position].getZona());
                }

                zone = new Zonas(datos[position].getId(), datos[position].getZona(), datos[position].getPais(), datos[position].getPrecio());
            }
        });

        peso = (EditText) findViewById(R.id.weight);

        normal = (RadioButton) findViewById(R.id.normal);
        normal.toggle();

        urgente = (RadioButton) findViewById(R.id.urgente);

        caja = (CheckBox) findViewById(R.id.caja);

        tarjeta = (CheckBox) findViewById(R.id.tarjeta);
    }

    public void calcular (View view) {
        Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);

        if (Double.valueOf(peso.getText().toString()) < 5)
            precioKilo = Double.valueOf(peso.getText().toString());
        if (Double.valueOf(peso.getText().toString()) > 6 && Float.valueOf(peso.getText().toString()) < 10)
            precioKilo = Double.valueOf(peso.getText().toString()) * 1.5;
        if (Double.valueOf(peso.getText().toString()) > 10)
            precioKilo = Double.valueOf(peso.getText().toString()) * 2;

        total = precioKilo + precioZona;

        if (urgente.isChecked())
            total *= 1.3;

        Bundle miBundle = new Bundle();
        miBundle.putSerializable("TODO", zone);
        if (!urgente.isChecked())
            miBundle.putString("TARIFA", "Normal");
        else
            miBundle.putString("TARIFA", "Urgente");
        miBundle.putDouble("PESO", Double.valueOf(peso.getText().toString()));

        if (caja.isChecked() && !tarjeta.isChecked())
            miBundle.putString("DECO", "Caja Regalo");
        else if (!caja.isChecked() && tarjeta.isChecked())
            miBundle.putString("DECO", "Tarjeta Dedicada");
        else if (caja.isChecked() && tarjeta.isChecked())
            miBundle.putString("DECO", "Caja Regalo Y Tarjeta Dedicada");

        miBundle.putDouble("PRECIO", total);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);
    }

    static class ViewHolder {
        TextView zona;
        TextView pais;
        TextView precio;
    }

    class AdaptadorZonas extends ArrayAdapter {
        Activity context;

        AdaptadorZonas(Activity context) {
            super(context, R.layout.linear_text_view, datos);
            this.context = context;
        }

        public View getView (int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.linear_text_view, null);
                holder = new ViewHolder();
                holder.zona = (TextView) item.findViewById(R.id.zona);
                holder.pais = (TextView) item.findViewById(R.id.pais);
                holder.precio = (TextView) item.findViewById(R.id.precio);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.zona.setText(datos[position].getZona());

            holder.pais.setText(datos[position].getPais());

            holder.precio.setText(datos[position].getPrecio());

            return (item);
        }
    }
}
