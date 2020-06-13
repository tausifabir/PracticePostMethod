package com.example.cricketapiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameET,passET;

    private Button loginBTN,RegistrationBTN;
    private Sharedpreferences sharedpreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Intent intent = getIntent();
        intWidget();


    }



    private void intWidget() {

        final Sharedpreferences sharedpreferences = new Sharedpreferences( this);

        usernameET = findViewById(R.id.usernameText);
        passET = findViewById(R.id.passwordText);
        loginBTN = findViewById(R.id.loginBtn);
        RegistrationBTN = findViewById(R.id.registrationBtn);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameET.getText().toString();
                String passNum =         passET.getText().toString();

                if(username.equals(sharedpreferences.getUserEmail()) && passNum.equals(sharedpreferences.getUserPass())){
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    public void Click(View view) {
        Intent intent1 = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent1);
    }
}