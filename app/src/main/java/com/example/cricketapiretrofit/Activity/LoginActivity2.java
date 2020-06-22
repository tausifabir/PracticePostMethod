package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cricketapiretrofit.R;

public class LoginActivity2 extends AppCompatActivity {

    private Button loginBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginBtn1 = findViewById(R.id.loginBtn1);

        loginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity2.this,NewLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}