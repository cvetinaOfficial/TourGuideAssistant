package com.tourguideassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton goToProfile, addTrip;
    TextView listOfLandmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String extra = intent.getStringExtra(Login.CURRENT_USER);

        goToProfile = findViewById(R.id.goToProfile);
        addTrip = findViewById(R.id.addTrip);
        listOfLandmarks = findViewById(R.id.item1);

        listOfLandmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent openLandmarkIntent = new Intent(MainActivity.this, Landmark.class);
                startActivity(openLandmarkIntent);
            }
        });

        addTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent openTripPreferencesIntent = new Intent(MainActivity.this, TripPreferences.class);
                startActivity(openTripPreferencesIntent);
            }
        });

        goToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent openUserPreferencesIntent = new Intent(MainActivity.this, UserPreferences.class);
                startActivity(openUserPreferencesIntent);
            }
        });
    }
}