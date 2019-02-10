package com.example.rafael.finalproject;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CountriesScreen extends AppCompatActivity {

    int USER;

    Fragment visitedCountryFragment, visitCountryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_screen);

        USER = getIntent().getIntExtra("USER", 0);

        Bundle bundle = new Bundle();
        bundle.putInt("USER", USER);
        visitCountryFragment = new visitCountries();
        visitedCountryFragment = new visitedCountries();
        visitCountryFragment.setArguments(bundle);
        visitedCountryFragment.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.visitCountries, visitCountryFragment).replace(R.id.visitedCountriesUser, visitedCountryFragment).addToBackStack(null).commit();
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
