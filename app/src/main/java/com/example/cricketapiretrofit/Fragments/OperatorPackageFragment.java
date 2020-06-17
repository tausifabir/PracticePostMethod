package com.example.cricketapiretrofit.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricketapiretrofit.Activity.MainActivity;
import com.example.cricketapiretrofit.Activity.MobilePackageDetailsActivity;
import com.example.cricketapiretrofit.Activity.RetrofitClient;
import com.example.cricketapiretrofit.Adapter.PackageAdapter;
import com.example.cricketapiretrofit.Interface.ProfileableInterface;
import com.example.cricketapiretrofit.Model.InternetPackageModel;
import com.example.cricketapiretrofit.Model.InternetPakageListModel;
import com.example.cricketapiretrofit.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OperatorPackageFragment extends Fragment {


    private RecyclerView packageRecycler;
    private PackageAdapter packageAdapter;
    private List<InternetPakageListModel>InternetPackageList;

    private String operator;

    public OperatorPackageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_operator_package, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        Bundle bundle = this.getArguments();
        if (bundle != null) {
            operator = bundle.getString("id","1");
        }

        packageRecycler = view.findViewById(R.id.frag_operatorPackageRV);

        loadInternetPakage();

    }


    private void loadInternetPakage() {

        ProfileableInterface profileableInterface = RetrofitClient.getClient(MainActivity.BaseUrl)
                .create(ProfileableInterface.class);

        profileableInterface.getInternetPakage("1",operator)
                .enqueue(new Callback<InternetPackageModel>() {
                    @Override
                    public void onResponse(Call<InternetPackageModel> call, Response<InternetPackageModel> response) {

                        if(response.isSuccessful()){

                            InternetPackageList = response.body().getReport();
                            packageAdapter = new PackageAdapter(getContext(),InternetPackageList);
                            GridLayoutManager gridLayoutManager =  new GridLayoutManager(getContext(),2);
                            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            packageRecycler.setLayoutManager(gridLayoutManager);
                            packageRecycler.setAdapter(packageAdapter);
                            Toast.makeText(getContext(), ""+operator, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<InternetPackageModel> call, Throwable t) {

                        //Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });



    }





}