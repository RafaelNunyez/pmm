package com.example.rafael.finalproject;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class visitedCountries extends Fragment {
    int user;

    ListView visitedCountryList;

    DatabaseHelper dbHelper;

    ArrayList<String> userCountries;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_visited_countries, container, false);

        if (getArguments() != null) {
            user = getArguments().getInt("USER", 0);
            visitedCountryList = (ListView) view.findViewById(R.id.visitedCountriesUser);

            dbHelper = new DatabaseHelper(getActivity());
            dbHelper.open();

            userCountries = new ArrayList();

            Cursor cursor = dbHelper.getItems(
                    SQLSentences.TABLE_COUNTRY_USER_REL + ", " + SQLSentences.TABLE_COUNTRY,
                    new String[] {SQLSentences.TABLE_COUNTRY + "." + SQLSentences.TABLE_COUNTRY_NAME},
                    SQLSentences.TABLE_COUNTRY_USER_REL_COUNTRY_ID + " = " +
                            SQLSentences.TABLE_COUNTRY + "." +
                            SQLSentences.TABLE_COUNTRY_ID + " AND " +
                            SQLSentences.TABLE_COUNTRY_USER_REL_VISITED + " = ? AND user_id = ?",
                    new String[] {String.valueOf(1), String.valueOf(user)},
                    SQLSentences.TABLE_COUNTRY_USER_REL + "." +
                            SQLSentences.TABLE_COUNTRY_USER_REL_ID);

            if (cursor.getCount() != 0)
                while (cursor.moveToNext())
                    userCountries.add(cursor.getString(0));

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, userCountries);

            visitedCountryList.setAdapter(adapter);

            dbHelper.close();
        }
        return view;
    }
}
