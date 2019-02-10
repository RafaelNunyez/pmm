package com.example.rafael.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Add extends AppCompatActivity {

    int USER;
    int visitValue, visitedValue;

    DatabaseHelper dbHelper;

    ArrayList<String> countries;

    Spinner countryList;
    Button insert;
    RadioButton visit, visited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dbHelper = new DatabaseHelper(this);
        dbHelper.open();

        countries = new ArrayList();

        final Cursor cursor2 = dbHelper.getItems(
                SQLSentences.TABLE_COUNTRY,
                new String[] {
                        SQLSentences.TABLE_COUNTRY_ID,
                        SQLSentences.TABLE_COUNTRY_NAME},
                null,
                null,
                SQLSentences.TABLE_COUNTRY_ID);

        while (cursor2.moveToNext())
            countries.add(cursor2.getString(1));

        countryList = (Spinner) findViewById(R.id.countryList);
        insert = (Button)findViewById(R.id.insert);
        visit = (RadioButton) findViewById(R.id.visit);
        visited = (RadioButton) findViewById(R.id.visited);

        USER = getIntent().getIntExtra("USER", 0);

        countryList.setAdapter(new CountryAdapter(getApplicationContext(), countries));


        insert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (visit.isChecked()) {
                    visitValue = 1;
                    visitedValue = 0;
                } else if (visited.isChecked()) {
                    visitValue = 0;
                    visitedValue = 1;
                }

                int itemPosition = countryList.getSelectedItemPosition() + 1;

                dbHelper.insertItem(
                        String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (%s, %s, %s, %s)",
                                SQLSentences.TABLE_COUNTRY_USER_REL,
                                SQLSentences.TABLE_COUNTRY_USER_REL_USER_ID,
                                SQLSentences.TABLE_COUNTRY_USER_REL_COUNTRY_ID,
                                SQLSentences.TABLE_COUNTRY_USER_REL_VISIT,
                                SQLSentences.TABLE_COUNTRY_USER_REL_VISITED,
                                USER,
                                itemPosition,
                                visitValue,
                                visitedValue
                        ));
                Toast.makeText(getApplicationContext(), "Added country", Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void onStop () {
        super.onStop();
        dbHelper.close();
    }

    protected void onPause () {
        super.onPause();
        dbHelper.close();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);

        super.onBackPressed();
    }
}

class CountryAdapter extends ArrayAdapter {

    public CountryAdapter(Context context, ArrayList<String> objects) {
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
                    R.layout.linear_country_spinner, parent, false
            );
        }

        TextView name = convertView.findViewById(R.id.name);

        String currentItem = (String) getItem(position);

        if (currentItem != null) {
            name.setText(currentItem);
        }

        return convertView;
    }
}
