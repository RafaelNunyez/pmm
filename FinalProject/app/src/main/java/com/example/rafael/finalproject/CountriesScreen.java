package com.example.rafael.finalproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CountriesScreen extends AppCompatActivity {

    int USER;

    DatabaseHelper dbHelper;

    ArrayList<String> userCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new DatabaseHelper(this);
        dbHelper.open();

        userCountries = new ArrayList();

        Cursor cursor2 = dbHelper.getItems(
                SQLSentences.TABLE_COUNTRY_USER_REL,
                new String[] {SQLSentences.TABLE_COUNTRY_NAME},
                "user_id = ?",
                new String[] {String.valueOf(USER)},
                SQLSentences.TABLE_COUNTRY_ID);
        while (cursor2.moveToNext()) {
            userCountries.add(cursor2.getString(0));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userCountries);

        USER = getIntent().getIntExtra("USER", 0);

        setContentView(R.layout.activity_countries_screen);

        ListView countryView = (ListView) findViewById(R.id.countryView);
        countryView.setAdapter(adapter);

        dbHelper.close();
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
}
