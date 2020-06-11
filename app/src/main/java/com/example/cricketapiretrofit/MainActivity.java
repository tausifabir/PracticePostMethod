package com.example.cricketapiretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.cricketapiretrofit.Adapter.ProfileAdapter;
import com.example.cricketapiretrofit.Interface.ProfileableInterface;
import com.example.cricketapiretrofit.Model.Profile;
import com.example.cricketapiretrofit.Model.ProfileModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static  String BaseUrl = "http://theroadofhumanity.com/";
    ProfileAdapter profileAdapter;
    private RecyclerView profileRecycler;
    private List<ProfileModel> profileModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileRecycler = findViewById(R.id.continentRecyclerView);


        checkProfilePost();

    }

    private void checkProfilePost() {

        final ProfileableInterface profileableInterface = RetrofitClient
                .getClient(BaseUrl)
                .create(ProfileableInterface.class);





        profileableInterface.getProfiles("3")
                .enqueue(new Callback<ProfileModel>() {
                    @Override
                    public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {

                        ProfileModel profileModel1 = response.body();

                        List<Profile> profiles = profileModel1.getProfiles();
                        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(MainActivity.this);
                        profileAdapter = new ProfileAdapter(MainActivity.this,profiles);
                        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        profileRecycler.setLayoutManager(linearLayoutManager);
                        profileRecycler.setAdapter(profileAdapter);


                        Toast.makeText(MainActivity.this, ""+profileModel1.getProfiles().get(3).getSL(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, ""+profileModel1.getProfiles().get(3).getTitle(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, ""+profileModel1.getProfiles().get(3).getDetails(), Toast.LENGTH_SHORT).show();
                        Log.e("Test", "onResponse: "+profileModel1.getProfiles().get(3).getDetails());
                        Log.e("Test", "onResponse: "+profileModel1.getProfiles().get(3).getDetails());





                       /* profileAdapter = new ProfileAdapter(MainActivity.this,profileModel1.getProfiles());
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
                        profileRecycler.setLayoutManager(gridLayoutManager);
                        profileAdapter.notifyDataSetChanged();
                        profileRecycler.setAdapter(profileAdapter);*/



                    }

                    @Override
                    public void onFailure(Call<ProfileModel> call, Throwable t) {

                        Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}