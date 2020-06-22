package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cricketapiretrofit.R;

public class FundActivity extends AppCompatActivity {

    private Button transferBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundtransfer);

        transferBtn = findViewById(R.id.transferBtn);

        transferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FundActivity.this,LoginActivity2.class);
                startActivity(intent);
            }
        });
    }
}