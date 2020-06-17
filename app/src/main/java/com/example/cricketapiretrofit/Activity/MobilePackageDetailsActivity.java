package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cricketapiretrofit.Adapter.PackageAdapter;
import com.example.cricketapiretrofit.Interface.ProfileableInterface;
import com.example.cricketapiretrofit.Model.InternetPackageModel;
import com.example.cricketapiretrofit.Model.InternetPakageListModel;
import com.example.cricketapiretrofit.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobilePackageDetailsActivity extends AppCompatActivity {


    RecyclerView recyclerVieww;
    PackageAdapter packageAdapter;
    private List<InternetPakageListModel>InternetPackageList;
    private String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_package_details);


        Intent intent = getIntent();

        operator = intent.getStringExtra("operatorId");

        recyclerVieww= findViewById(R.id.recycler_view_list);
        /*recyclerVieww.setHasFixedSize(true);
        recyclerVieww.setLayoutManager(new GridLayoutManager(this, 2));*/

        Toast.makeText(this, " "+operator, Toast.LENGTH_SHORT).show();


        loadInternetPakage();

    }




    private void loadInternetPakage() {

        ProfileableInterface profileableInterface = RetrofitClient.getClient(MainActivity.BaseUrl)
                .create(ProfileableInterface.class);

        profileableInterface.getInternetPakage("4",operator)
                .enqueue(new Callback<InternetPackageModel>() {
                    @Override
                    public void onResponse(Call<InternetPackageModel> call, Response<InternetPackageModel> response) {

                        if(response.isSuccessful()){

                            InternetPackageList = response.body().getReport();
                            packageAdapter = new PackageAdapter(MobilePackageDetailsActivity.this,InternetPackageList);
                            GridLayoutManager gridLayoutManager =  new GridLayoutManager(MobilePackageDetailsActivity.this,2);
                            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            recyclerVieww.setLayoutManager(gridLayoutManager);
                            recyclerVieww.setAdapter(packageAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<InternetPackageModel> call, Throwable t) {

                    }
                });



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}