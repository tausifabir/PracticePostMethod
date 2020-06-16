package com.example.cricketapiretrofit.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.cricketapiretrofit.Activity.MainActivity;
import com.example.cricketapiretrofit.Activity.RetrofitClient;
import com.example.cricketapiretrofit.Adapter.PackageAdapter;
import com.example.cricketapiretrofit.Interface.ProfileableInterface;
import com.example.cricketapiretrofit.Model.InternetPakageListModel;
import com.example.cricketapiretrofit.Model.InternetPakageModel;
import com.example.cricketapiretrofit.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OperatorPackageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OperatorPackageFragment extends Fragment {


    private RecyclerView packageRecycler;
    private PackageAdapter packageAdapter;
    List<InternetPakageListModel> internetPakageListModelList;
    private InternetPakageModel internetPakageListModels;
    private String operator;

    public OperatorPackageFragment() {
        // Required empty public constructor
    }

    public static OperatorPackageFragment newInstance(String param1, String param2) {
        OperatorPackageFragment fragment = new OperatorPackageFragment();
        Bundle args = new Bundle();
        ;
        fragment.setArguments(args);
        return fragment;
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




    }



}