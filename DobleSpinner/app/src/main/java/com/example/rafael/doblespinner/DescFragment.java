package com.example.rafael.doblespinner;

import android.os.Bundle;
import android.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescFragment extends Fragment {

    Movies movie;

    TextView description;

    static DescFragment newInstance() {
        DescFragment f = new DescFragment();
        return f;
    }

    static DescFragment newInstance(Movies movie) {
        DescFragment f = new DescFragment();
        Bundle args = new Bundle();
        args.putSerializable("MOVIE_DESC", movie);
        f.setArguments(args);
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_desc, container, false);

        if (getArguments() != null) {
            movie = (Movies) getArguments().getSerializable("MOVIE_DESC");

            // This needs to be within the {} or can give a NullPointerException
            description = (TextView) view.findViewById(R.id.descript);
            description.setText(movie.getDescription());
            description.setMovementMethod(new ScrollingMovementMethod());
        }
        return view;

    }
}
