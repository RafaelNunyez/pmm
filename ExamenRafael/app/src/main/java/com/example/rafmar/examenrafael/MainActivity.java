package com.example.rafmar.examenrafael;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int precioCoche;
    private static double horas;
    private static EditText tiempo;
    private static RadioButton noSeguro;
    private static RadioButton seguro;
    private static TextView eleccion;
    private static CheckBox ac;
    private static CheckBox gps;
    private static CheckBox dvd;
    private static TextView precio;
    private double total;
    private double extras = 0;
    private Coches coche;

    private Coches[] coches = new Coches[] {
        new Coches(0, "Megane", "Seat", 20, R.drawable.megan1),
        new Coches(1, "X-11", "Ferrari", 100, R.drawable.ferrari1),
        new Coches(2, "Leon", "Seat", 30, R.drawable.leon1),
        new Coches(3, "Fiesta", "Ford", 40, R.drawable.fiesta1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lstOpciones = (ListView) findViewById(R.id.opciones);
        AdaptadorCoches adaptador = new AdaptadorCoches(this);
        lstOpciones.setAdapter(adaptador);
        eleccion = (TextView) findViewById(R.id.eleccion);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView arg0, View arg1, int position, long id) {
                switch (position) {
                    case 0:
                        precioCoche = coches[position].getPrecio();
                    case 1:
                        precioCoche = coches[position].getPrecio();
                    case 2:
                        precioCoche = coches[position].getPrecio();
                    case 3:
                        precioCoche = coches[position].getPrecio();
                }

                eleccion.setText("Coche Elegido: " + coches[position].getMarca() + " " + coches[position].getModelo());

                coche = new Coches(coches[position].getId(), coches[position].getModelo(), coches[position].getMarca(), coches[position].getPrecio(), coches[position].getImagen());
            }
        });

        tiempo = (EditText) findViewById(R.id.horas);

        noSeguro = (RadioButton) findViewById(R.id.noSeguro);
        noSeguro.toggle();

        seguro = (RadioButton) findViewById(R.id.seguro);

        ac = (CheckBox) findViewById(R.id.aire);

        gps = (CheckBox) findViewById(R.id.gps);

        dvd = (CheckBox) findViewById(R.id.radio);

        precio = (TextView) findViewById(R.id.total);
    }

    public void calcular (View view) {
        extras = 0;
        horas = Double.valueOf(tiempo.getText().toString());

        total = horas * precioCoche;

        if (ac.isChecked())
            extras += 50;
        if(gps.isChecked())
            extras += 50;
        if (dvd.isChecked())
            extras += 50;

        total += extras;

        if (seguro.isChecked())
            total *= 1.2;

        precio.setText(Double.valueOf(total).toString());
    }

    public void factura (View view) {
        extras = 0;
        horas = Double.valueOf(tiempo.getText().toString());

        Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
        Bundle miBundle = new Bundle();

        miBundle.putSerializable("TODO", coche);

        if (ac.isChecked())
            extras += 50;
        if(gps.isChecked())
            extras += 50;
        if (dvd.isChecked())
            extras += 50;

        miBundle.putDouble("EXTRAS", extras);

        miBundle.putString("HORAS", String.valueOf(horas));

        total = horas * precioCoche + extras;

        if (noSeguro.isChecked())
            miBundle.putString("SEGURO", "Sin seguro");
        else {
            miBundle.putString("SEGURO", "Seguro a todo riesgo");
            total *= 1.2;
        }

        miBundle.putDouble("PRECIO", total);

        miIntent.putExtras(miBundle);
        startActivity(miIntent);
    }

    static class ViewHolder {
        TextView modelo;
        TextView marca;
        TextView precio;
        ImageView imagen;
    }

    class AdaptadorCoches extends ArrayAdapter {
        Activity context;

        AdaptadorCoches(Activity context) {
            super(context, R.layout.linear_text_view, coches);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView (int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.linear_text_view, null);
                holder = new ViewHolder();
                holder.modelo = (TextView) item.findViewById(R.id.modelo);
                holder.marca = (TextView) item.findViewById(R.id.marca);
                holder.precio = (TextView) item.findViewById(R.id.precio);
                holder.imagen = (ImageView) item.findViewById(R.id.imagen);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.modelo.setText(coches[position].getModelo());

            holder.marca.setText(coches[position].getMarca());

            holder.precio.setText(coches[position].getPrecio() + "€");

            holder.imagen.setBackground(getDrawable(coches[position].getImagen()));

            return (item);
        }
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        /*switch (item.getItemId()) {
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
        }*/
        return true;
    }
}
