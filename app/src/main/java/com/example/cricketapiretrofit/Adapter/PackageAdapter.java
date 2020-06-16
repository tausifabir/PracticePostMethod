package com.example.cricketapiretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapiretrofit.Model.InternetPakageListModel;
import com.example.cricketapiretrofit.R;

import java.util.List;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.BalanceViewHolder>
{
    private Context context;
    private List<InternetPakageListModel> internetBalanceDetails;
    private OnItemClickListner listner;




    public interface OnItemClickListner
    {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListner mylistener)
    {
        listner = mylistener;
    }

    //constructor
    public PackageAdapter(Context myContext, List<InternetPakageListModel> internetBalanceDetails)
    {
        context = myContext;
        this.internetBalanceDetails = internetBalanceDetails;
    }


    //creating viewholder to get the layout
    @NonNull
    @Override
    public BalanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.package_row, parent, false);
        return new BalanceViewHolder(view);
    }


    //setting all the data
    @Override
    public void onBindViewHolder(@NonNull BalanceViewHolder holder, int position)
    {
        InternetPakageListModel internetPakageListModel = internetBalanceDetails.get(position);


        holder.dataAmount.setText(internetPakageListModel.getTitle());
        holder.balance.setText(internetPakageListModel.getAmount()+"৳");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(context, PakageBuyActivity.class);
                intent.putExtra("amount",internetPakageListModel.getAmount());
                context.startActivity(intent);*/
            }
        });
    }

    //item size
    @Override
    public int getItemCount()
    {
        return internetBalanceDetails.size();
    }


    //calling all the references of items of layout
    public class BalanceViewHolder extends RecyclerView.ViewHolder
    {

        TextView dataAmount, balance;

        public BalanceViewHolder(@NonNull View itemView)
        {
            super(itemView);

            dataAmount = itemView.findViewById(R.id.details_data_adapter);
            balance = itemView.findViewById(R.id.balance_adapter);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (listner!= null) //checks if it has listener
                    {
                        int position = getAdapterPosition(); //storing position
                        if (position != RecyclerView.NO_POSITION) //if position is listed
                        {
                            listner.onItemClick(position); //interface created
                        }
                    }
                }
            });
        }
    }
}
