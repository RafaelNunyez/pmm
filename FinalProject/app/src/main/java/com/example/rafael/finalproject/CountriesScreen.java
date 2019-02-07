package com.example.rafael.finalproject;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CountriesScreen extends AppCompatActivity {

    int USER;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

        USER = getIntent().getIntExtra("USER", 0);

        dbHelper = new DatabaseHelper(this);

        setContentView(R.layout.activity_countries_screen);

        ListView countryView = (ListView) findViewById(R.id.countryView);
        countryView.setAdapter(adaptador);
    }

    static class ViewHolder {
        TextView lblCountry;
    }

    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares (Activity context) {
            super(context, R.layout.linear_menu_item);
            this.context = context;
        }

        public View getView (int position, View convertView, ViewGroup parent) {
            String[] columns = {
                    SQLSentences.TABLE_COUNTRY_USER_REL_COUNTRY_ID,
                    SQLSentences.TABLE_COUNTRY_NAME
            };

            View item = convertView;
            ViewHolder holder;

            Cursor cursor;
            dbHelper.open();
            cursor = dbHelper.getItems(SQLSentences.TABLE_COUNTRY_USER_REL, columns, "id = ?",
                    new String[]{String.valueOf(USER)}, SQLSentences.TABLE_COUNTRY_USER_REL_ID);

            if (cursor.moveToFirst()) {


                if (item == null) {
                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.linear_menu_item, null);
                    holder = new ViewHolder();
                    holder.lblCountry = (TextView) item.findViewById(R.id.Country);

                    item.setTag(holder);
                } else {
                    holder = (ViewHolder) item.getTag();
                }

                holder.lblCountry.setText(cursor.getString(2));
            }

            if (!cursor.isClosed()) {
                cursor.close();
            }
            
            dbHelper.close();

            return (item);
        }
    }
}
