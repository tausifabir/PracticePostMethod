package com.example.cricketapiretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapiretrofit.R;
import com.google.gson.JsonObject;

public class WithdrawAdapter extends RecyclerView.Adapter<WithdrawAdapter.WithdrawViewHolder>  {

    private Context context;
    private JsonObject jsonObject;

    public WithdrawAdapter(Context context, JsonObject jsonObject) {
        this.context = context;
        this.jsonObject = jsonObject;
    }

    @NonNull
    @Override
    public WithdrawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.continent_row,parent,false);

        return new WithdrawAdapter.WithdrawViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WithdrawViewHolder holder, int position) {

        holder.profileTitle.setText("Information");
        holder.profileDetails.setText(jsonObject.get("balance").getAsString());

    }

    @Override
    public int getItemCount() {
        return jsonObject.size();
    }

    public class WithdrawViewHolder extends RecyclerView.ViewHolder{

        private TextView profileTitle, profileDetails,profileDot;
        public WithdrawViewHolder(@NonNull View itemView) {
            super(itemView);

            profileTitle = itemView.findViewById(R.id.personInfoTV);
            profileDetails = itemView.findViewById(R.id.personShowTV);
            profileDot = itemView.findViewById(R.id.personDot);
        }
    }
}
