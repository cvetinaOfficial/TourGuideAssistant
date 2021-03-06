package com.tourguideassistant;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tourguideassistant.persistence.entity.UserEntity;
import com.tourguideassistant.repository.UserRepository;

import java.io.Serializable;

public class Login extends AppCompatActivity {
    public static final String CURRENT_USER = "User";
    UserRepository userRepository;
    EditText username, password;
    Button login;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = getApplicationContext();

        username = findViewById(R.id.editTexUsername);
        password = findViewById(R.id.editTexPassword);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    userRepository = new UserRepository((Application) context.getApplicationContext());

                    if(userRepository.findUserByUsername(username.getText().toString()) != null){
                        UserEntity user = userRepository.getUserEntityLiveData(username.getText().toString(), password.getText().toString());

                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra(CURRENT_USER, (Serializable) user);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Потребител с такова име не съществува!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    /** Called when the user taps the Send button */
    public void goToRegistration(View view) {
        Intent intent = new Intent(this, Register.class);
        Button registerButton = (Button) findViewById(R.id.register);
        startActivity(intent);
    }
}