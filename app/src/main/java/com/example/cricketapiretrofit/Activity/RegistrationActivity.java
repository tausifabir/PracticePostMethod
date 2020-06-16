package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cricketapiretrofit.R;
import com.example.cricketapiretrofit.SharedPreferenceClass.Userpreferences;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailET,emailpassET;
    private Button RegisterBTN;
    private Userpreferences userpreferences;


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
        userpreferences = new Userpreferences(this);
        String pass = emailpassET.getText().toString();

        String email = emailET.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailET.setError("invaild");

        }else  if(TextUtils.isEmpty(pass)){
            emailpassET.setError("invaild");
        }
        else {
            userpreferences.saveUser(email,pass);
            Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, ""+userpreferences.getUserEmail(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();

        }




    }
}