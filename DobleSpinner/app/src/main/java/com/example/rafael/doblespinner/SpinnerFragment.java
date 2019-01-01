package com.example.rafael.doblespinner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class SpinnerFragment extends Fragment {

    Spinner authors = null;
    Spinner works = null;
    private FragmentTransaction ft;

    ArrayList<Autores> autores = new ArrayList<Autores>(
            Arrays.asList(
                    new Autores(0, "Megane", "Seat", "España", 20, new ArrayList<Obras> (
                            Arrays.asList(
                                    new Obras(0, "A", "Seat", "",
                                            "bvsrdfbv rdfbcv"),
                                    new Obras(1, "B", "Ferrari", "",
                                            "hhsdf"),
                                    new Obras(2, "Leon", "Seat", "",
                                            "sdfg"),
                                    new Obras(3, "Fiesta", "Ford", "",
                                            "sdfg")
                            )
                    )),
                    new Autores(1, "X-11", "Ferrari", "España", 20, new ArrayList<Obras> (
                            Arrays.asList(
                                    new Obras(0, "C", "Seat", "",
                                            "sdfg"),
                                    new Obras(1, "D", "Ferrari", "",
                                            "sdf"),
                                    new Obras(2, "Leon", "Seat", "",
                                            "sdf"),
                                    new Obras(3, "Fiesta", "Ford", "",
                                            "sdfg")
                            )
                    )),
                    new Autores(2, "Leon", "Seat", "España", 20, new ArrayList<Obras> (
                            Arrays.asList(
                                    new Obras(0, "Megane", "Seat", "",
                                            "sdfg"),
                                    new Obras(1, "X-11", "Ferrari", "",
                                            "sdfg"),
                                    new Obras(2, "Leon", "Seat", "",
                                            "sdfg"),
                                    new Obras(3, "Fiesta", "Ford", "",
                                            "sdfg")
                            )
                    )),
                    new Autores(3, "Fiesta", "Ford", "España", 20, new ArrayList<Obras> (
                            Arrays.asList(
                                    new Obras(0, "Megane", "Seat", "",
                                            ""),
                                    new Obras(1, "X-11", "Ferrari", "",
                                            ""),
                                    new Obras(2, "Leon", "Seat", "",
                                            ""),
                                    new Obras(3, "Fiesta", "Ford", "",
                                            "")
                            )
                    ))
            )
    );

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_spinner, container, false);
        authors = (Spinner) view.findViewById(R.id.writers);
        works = (Spinner) view.findViewById(R.id.works);

        authors.setAdapter(new AdaptadorAutores(getActivity(), autores));

        authors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                works.setAdapter(new AdaptadorObras(getActivity(), autores.get(position).getObras()));

                final ArrayList<Obras> obras = autores.get(position).getObras();

                works.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                        MainActivity.description = obras.get(position).getDescription();

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.description, new DescFragment()).addToBackStack(null).commit();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
        return view;
    }
}

class AdaptadorAutores extends ArrayAdapter {

    public AdaptadorAutores(Context context, ArrayList<Autores> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.linear_spinner_author, parent, false
            );
        }

        TextView nombre = convertView.findViewById(R.id.nombre);
        TextView lenguaje = convertView.findViewById(R.id.lenguaje);
        TextView nacimiento = convertView.findViewById(R.id.nacimiento);
        TextView numeroObras = convertView.findViewById(R.id.obras);
        ImageView autor = convertView.findViewById(R.id.imagen);

        Autores currentItem = (Autores) getItem(position);

        if (currentItem != null) {
            nombre.setText("Nombre: " + currentItem.getNombre());
            lenguaje.setText("Lenguaje: " + currentItem.getLenguaje());
            nacimiento.setText("País de Origen: " + currentItem.getNacimiento());
            numeroObras.setText("Número de Obras: " + currentItem.getObras().size());
            //autor.setImageResource(currentItem.getImagen());
        }

        return convertView;
    }
}

class AdaptadorObras extends ArrayAdapter {

    public AdaptadorObras(Context context, ArrayList<Obras> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.linear_spinner_work, parent, false
            );
        }

        TextView nombre = convertView.findViewById(R.id.titulo);
        TextView lenguaje = convertView.findViewById(R.id.editorial);
        TextView nacimiento = convertView.findViewById(R.id.isbn);

        Obras currentItem = (Obras) getItem(position);

        if (currentItem != null) {
            nombre.setText("Título: " + currentItem.getTitulo());
            lenguaje.setText("Editorial: " + currentItem.getEditorial());
            nacimiento.setText("ISBN: " + currentItem.getIsbn());
        }

        return convertView;
    }
}
