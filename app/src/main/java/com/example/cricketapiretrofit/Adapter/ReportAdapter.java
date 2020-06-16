package com.example.cricketapiretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapiretrofit.Model.Report;
import com.example.cricketapiretrofit.Model.Report;
import com.example.cricketapiretrofit.R;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private Context context;
    private List<Report> reportDataModelList;

    public ReportAdapter(Context context, List<Report> reportDataModelList) {
        this.context = context;
        this.reportDataModelList = reportDataModelList;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.report_row,parent,false);

        return new ReportAdapter.ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {

        holder.textViewSL.setText(reportDataModelList.get(position).getSerial());
        holder.textViewFrom.setText("From: "+reportDataModelList.get(position).getFrom());
        holder.textViewDate.setText("Date: "+reportDataModelList.get(position).getDate());
        holder.textViewTo.setText("To: "+reportDataModelList.get(position).getTo());
        holder.textViewAmount.setText("Amount: "+reportDataModelList.get(position).getAmount());

    }

    @Override
    public int getItemCount() {
        return reportDataModelList.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewSL ,textViewFrom, textViewDate,textViewTo,textViewAmount;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewSL = itemView.findViewById(R.id.tv_rowFundTransferRepo_SL);
            textViewFrom = itemView.findViewById(R.id.tv_rowFundTransferRepo_From);
            textViewDate = itemView.findViewById(R.id.tv_rowFundTransferRepo_Date);
            textViewTo = itemView.findViewById(R.id.tv_rowFundTransferRepo_To);
            textViewAmount = itemView.findViewById(R.id.tv_rowFundTransferRepo_Amount);
        }
    }
}
