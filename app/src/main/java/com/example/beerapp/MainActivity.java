package com.example.beerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        ArrayList<String> categories = new ArrayList<>();
        categories.add(0, "Choose Beer Category");
        categories.add("Light");
        categories.add("Amber");
        categories.add("Brown");
        categories.add("Dark");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Choose Beer Category")){

                }
                else {
                    String item = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selected: " +item, Toast.LENGTH_SHORT).show();

                    if (parent.getItemAtPosition(position).equals("Light")){

                        Intent intent = new Intent(MainActivity.this, Light.class);
                        startActivity(intent);
                    } if (parent.getItemAtPosition(position).equals("Amber")){
                        Intent intent = new Intent(MainActivity.this, Amber.class);
                        startActivity(intent);
                    } if (parent.getItemAtPosition(position).equals("Brown")){
                        Intent intent = new Intent(MainActivity.this, Brown.class);
                        startActivity(intent);
                    } if (parent.getItemAtPosition(position).equals("Dark")){
                        Intent intent = new Intent(MainActivity.this, Dark.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void Exit(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}