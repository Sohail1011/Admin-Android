package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void RegisterOpen(View view) {
        Intent press = new Intent(this, RegisterActivity.class);
        startActivity(press);
    }

    public void ComponentsOpen(View view) {
        Intent press = new Intent(this, ComponentsActivity.class);
        startActivity(press);
    }
}