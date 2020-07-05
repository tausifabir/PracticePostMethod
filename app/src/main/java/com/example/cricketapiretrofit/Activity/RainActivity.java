package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.cricketapiretrofit.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class RainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;

    private Location location;

    private ImageView joingImg,transcationImg,teamImg,shopImg,supportImg,otherImg,dashboardUserID;


    LocationRequest locationRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_joiningdashboard);

        joingImg = findViewById(R.id.imageView10);
        transcationImg = findViewById(R.id.imageView11);
        teamImg = findViewById(R.id.imageView12);
        shopImg = findViewById(R.id.imageView13);
        supportImg = findViewById(R.id.imageView14);
        otherImg = findViewById(R.id.imageView15);
        dashboardUserID = findViewById(R.id.dashboardUserID);







        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        rotateAnimation();



    }


    private void rotateAnimation(){


        Animation RotateClk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        Animation antiRotateClk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        joingImg.startAnimation(RotateClk);
        teamImg.startAnimation(RotateClk);
        supportImg.startAnimation(RotateClk);

        transcationImg.startAnimation(antiRotateClk);
        shopImg.startAnimation(antiRotateClk);
        otherImg.startAnimation(antiRotateClk);

    }


}
