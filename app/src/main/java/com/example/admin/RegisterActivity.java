package com.example.admin;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    String[] items;

    AutoCompleteTextView autCountry;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Resources res = getResources();

        items = res.getStringArray(R.array.countries);

        autCountry = findViewById(R.id.autCountry);

        adapterItems = new ArrayAdapter<String>(this, R.layout.dropdown_item, items);

        autCountry.setAdapter(adapterItems);

        autCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });
    }
}