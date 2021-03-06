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

public class Register extends AppCompatActivity {

    UserRepository userRepository;
    EditText username, password, repeatPassword;
    Button register;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context = getApplicationContext();
        username = findViewById(R.id.editTexUsername);
        password = findViewById(R.id.editTextPassword);
        repeatPassword = findViewById(R.id.editRepeatPassword);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(password.getText().toString().equals(repeatPassword.getText().toString())){
                    userRepository = new UserRepository((Application) context.getApplicationContext());
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUsername(username.getText().toString());
                    userEntity.setPassword(password.getText().toString());
                    userRepository.registerUser(userEntity);
                    goToLogin(v);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Вашите пароли не съвпадат!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        Button registerButton = (Button) findViewById(R.id.register);
        startActivity(intent);
    }
}