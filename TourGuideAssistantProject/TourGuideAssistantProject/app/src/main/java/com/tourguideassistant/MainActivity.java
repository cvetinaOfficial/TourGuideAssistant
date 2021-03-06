package com.tourguideassistant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String extra = intent.getStringExtra(Login.CURRENT_USER);

        Toast.makeText(getApplicationContext(), "Test " + extra, Toast.LENGTH_SHORT).show();
    }
}