package com.example.rafael.doblespinner;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescFragment extends Fragment {

    TextView description;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_desc, container, false);


        description = (TextView) view.findViewById(R.id.descript);
        description.setText(MainActivity.description);
        return view;

    }
}
