package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cricketapiretrofit.R;

public class NewLoginActivity extends AppCompatActivity {

    private Button loginBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitity_newlogin);

        loginBtn2 = findViewById(R.id.loginBtn2);

        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewLoginActivity.this,NewLoginActivity2.class);
                startActivity(intent);
            }
        });
    }
}