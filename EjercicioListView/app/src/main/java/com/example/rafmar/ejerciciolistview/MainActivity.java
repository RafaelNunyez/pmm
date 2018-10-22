package com.example.rafmar.ejerciciolistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Titular[] datos = new Titular[] {
            new Titular("Titulo 1", "Subtitulo largo 1"),
            new Titular("Titulo 2", "Subtitulo largo 2")
    };

    Titular tit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView arg0, View arg1, int position, long id) {

                tit = new Titular(datos[position].getTitulo(), datos[position].getSubtitulo());

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                miBundle.putSerializable("TODO", tit);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);

                // Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }

    static class ViewHolder {
        TextView lblTitulo;
        TextView lblSubtitulo;
    }

    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares (Activity context) {
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
                holder.lblTitulo = (TextView) item.findViewById(R.id.tvTitulo);
                holder.lblSubtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);

                item.setTag(holder);
            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.lblTitulo.setText(datos[position].getTitulo());

            holder.lblSubtitulo.setText(datos[position].getSubtitulo());

            return (item);
        }
    }
}
