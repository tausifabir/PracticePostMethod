package com.example.cricketapiretrofit.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricketapiretrofit.Activity.MainActivity;
import com.example.cricketapiretrofit.Activity.ReportActivity;
import com.example.cricketapiretrofit.Activity.RetrofitClient;
import com.example.cricketapiretrofit.Adapter.ReportAdapter;
import com.example.cricketapiretrofit.Interface.ProfileableInterface;
import com.example.cricketapiretrofit.Model.FundTransferReportDataModel;
import com.example.cricketapiretrofit.Model.Report;
import com.example.cricketapiretrofit.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransferReportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransferReportFragment extends Fragment {


    private RecyclerView reportRecycler;
    private ReportAdapter reportAdapter;



    public TransferReportFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transfer_report, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        reportRecycler = view.findViewById(R.id.frag_reportRV);
        getReportPostApi();
    }

    private void getReportPostApi() {

        ProfileableInterface profileableInterface = RetrofitClient
                .getClient(MainActivity.BaseUrl)
                .create(ProfileableInterface.class);

        int load = 0;
        profileableInterface.getFundTransferReport("raju1","909090","member","0,5","1")
                .enqueue(new Callback<FundTransferReportDataModel>() {
                    @Override
                    public void onResponse(Call<FundTransferReportDataModel> call, Response<FundTransferReportDataModel> response) {

                        if(response.isSuccessful()){

                            List<Report> reportList = response.body().getReport();
                            reportAdapter = new ReportAdapter(getContext(),reportList);
                            LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getContext());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            reportRecycler.setLayoutManager(linearLayoutManager);
                            reportRecycler.setAdapter(reportAdapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<FundTransferReportDataModel> call, Throwable t) {

                        Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                });

    }
}