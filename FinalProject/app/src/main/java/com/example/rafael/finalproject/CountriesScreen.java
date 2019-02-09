package com.example.rafael.finalproject;

import android.content.Intent;
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
        setContentView(R.layout.activity_countries_screen);

        dbHelper = new DatabaseHelper(this);
        dbHelper.open();

        userCountries = new ArrayList();

        USER = getIntent().getIntExtra("USER", 0);

        Cursor cursor = dbHelper.getItems(
                SQLSentences.TABLE_COUNTRY_USER_REL + ", " + SQLSentences.TABLE_COUNTRY,
                new String[] {SQLSentences.TABLE_COUNTRY + "." + SQLSentences.TABLE_COUNTRY_NAME},
                SQLSentences.TABLE_COUNTRY_USER_REL_COUNTRY_ID + " = " +
                        SQLSentences.TABLE_COUNTRY + "." +
                        SQLSentences.TABLE_COUNTRY_ID + " AND user_id = ?",
                new String[] {String.valueOf(USER)},
                SQLSentences.TABLE_COUNTRY_USER_REL + "." +
                        SQLSentences.TABLE_COUNTRY_USER_REL_ID);

        if (cursor.getCount() != 0)
            while (cursor.moveToNext())
                userCountries.add(cursor.getString(0));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userCountries);

        ListView countryView = (ListView) findViewById(R.id.countryView);
        countryView.setAdapter(adapter);

        dbHelper.close();
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, Add.class);

                Bundle bundle = new Bundle();
                bundle.putInt("USER", USER);

                intent.putExtras(bundle);
                startActivityForResult(intent, 0);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK){
            finish();
            startActivity(getIntent());
        }
    }

}
