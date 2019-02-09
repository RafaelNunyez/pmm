package com.example.rafael.finalproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Add extends AppCompatActivity {

    int USER;

    DatabaseHelper dbHelper;

    ArrayList<String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_screen);

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);

        USER = getIntent().getIntExtra("USER", 0);

        ListView countryView = (ListView) findViewById(R.id.countryView);
        countryView.setAdapter(adapter);

        countryView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                dbHelper.insertItem(
                        String.format("INSERT INTO %s (%s, %s) VALUES (%s, %s)",
                                SQLSentences.TABLE_COUNTRY_USER_REL,
                                SQLSentences.TABLE_COUNTRY_USER_REL_USER_ID,
                                SQLSentences.TABLE_COUNTRY_USER_REL_COUNTRY_ID,
                                USER,
                                position + 1));
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
