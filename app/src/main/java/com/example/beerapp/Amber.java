package com.example.beerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Amber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amber);

        Button back1 = findViewById(R.id.button);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveback1();
            }
        });
    }

    private void moveback1(){
        Intent intent = new Intent(Amber.this, MainActivity.class);
        startActivity(intent);
    }
}