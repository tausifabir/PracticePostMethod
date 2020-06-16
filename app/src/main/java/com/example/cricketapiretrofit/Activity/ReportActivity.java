package com.example.cricketapiretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cricketapiretrofit.Adapter.ReportAdapter;
import com.example.cricketapiretrofit.Interface.ProfileableInterface;
import com.example.cricketapiretrofit.Model.FundTransferReportDataModel;
import com.example.cricketapiretrofit.Model.Report;
import com.example.cricketapiretrofit.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends AppCompatActivity {

    private RecyclerView reportRecycler;
    private ReportAdapter reportAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        intWidget();

        getReportPostApi();
    }


    private void intWidget() {

        reportRecycler = findViewById(R.id.reportRV);
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
                            reportAdapter = new ReportAdapter(ReportActivity.this,reportList);
                            LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(ReportActivity.this);
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            reportRecycler.setLayoutManager(linearLayoutManager);
                            reportRecycler.setAdapter(reportAdapter);

                            Toast.makeText(ReportActivity.this, ""+reportList.size(), Toast.LENGTH_LONG).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<FundTransferReportDataModel> call, Throwable t) {

                        Toast.makeText(ReportActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                });

    }

}