package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cricketapiretrofit.R;

public class NewLoginActivity2 extends AppCompatActivity {
    private Button loginBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlogin2);

        loginBtn3 =findViewById(R.id.loginBtn3);

        loginBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewLoginActivity2.this,Rain.class);
                startActivity(intent);
            }
        });
    }
}