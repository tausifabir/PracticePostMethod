package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cricketapiretrofit.R;
import com.example.cricketapiretrofit.SharedPreferenceClass.Userpreferences;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameET,passET;
    private ImageView imageView;

    private Button loginBTN,RegistrationBTN;
    private Userpreferences userpreferences;

    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        userpreferences = new Userpreferences(this);

      //  Intent intent = getIntent();
       // intWidget();

        toolbar = findViewById(R.id.toolbar);
        imageView = findViewById(R.id.imageViewTV);

        setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setDisplayShowHomeEnabled(true);






    }



    private void intWidget() {


        /*usernameET = findViewById(R.id.usernameText);
        passET = findViewById(R.id.passwordText);
        loginBTN = findViewById(R.id.loginBtn);
        RegistrationBTN = findViewById(R.id.registrationBtn);
         */
   /*     imageView = findViewById(R.id.imageViewTV);
        usernameET = findViewById(R.id.userNameET);
        passET = findViewById(R.id.passET);
        RegistrationBTN = findViewById(R.id.loginBTN);

        RegistrationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameET.getText().toString();
                String passNum =  passET.getText().toString();

                Toast.makeText(LoginActivity.this, ""+userpreferences.getUserEmail(), Toast.LENGTH_SHORT).show();
                if(username.equals(userpreferences.getUserEmail()) && passNum.equals(userpreferences.getUserPass())){
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
*/



    }

    public void Click(View view) {
        Intent intent1 = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent1);
    }
}