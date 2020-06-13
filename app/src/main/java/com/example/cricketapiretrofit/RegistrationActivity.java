package com.example.cricketapiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailET,emailpassET;
    private Button RegisterBTN;
    private Sharedpreferences sharedpreferences;


    public RegistrationActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Intent intent = getIntent();



        intWidget();
    }

    private void intWidget() {

        emailET = findViewById(R.id.emailText);
        emailpassET = findViewById(R.id.emailpassText);
        RegisterBTN = findViewById(R.id.registerBtn);

    }

    public void registerClick(View view) {
        Sharedpreferences sharedpreferences = new Sharedpreferences(this);
        String email = emailET.getText().toString();
        String pass = emailpassET.getText().toString();

        sharedpreferences.saveUser(email,pass);
        Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();

    }
}