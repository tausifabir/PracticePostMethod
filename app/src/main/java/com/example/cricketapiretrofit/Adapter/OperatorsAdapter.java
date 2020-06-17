package com.example.cricketapiretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapiretrofit.Model.OperatorsModel;
import com.example.cricketapiretrofit.R;

import java.util.ArrayList;

public class OperatorsAdapter extends RecyclerView.Adapter<OperatorsAdapter.ArtificialJsonViewHolder>
{
    private Context context;
    private ArrayList<OperatorsModel> operatorsModels;
    private OnItemClickListner listner;


    public OperatorsAdapter(Context context, ArrayList<OperatorsModel> operatorsModels) {
        this.context = context;
        this.operatorsModels = operatorsModels;
    }


    public interface OnItemClickListner {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListner mylistener) {
         listner = mylistener;
}




    //creating viewholder to get the layout
    @NonNull
    @Override
    public ArtificialJsonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.operator_row, parent, false);
        return new ArtificialJsonViewHolder(view);
    }


    //setting all the data
    @Override
    public void onBindViewHolder(@NonNull ArtificialJsonViewHolder holder, final int position) {
        OperatorsModel selectedItem = operatorsModels.get(position);

        holder.carrierName.setText(selectedItem.getOperatorName());
        holder.circleImageView.setImageResource(selectedItem.getImageID());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   listner.onItemClick(position); //interface created


            }
        });
    }

    //item size
    @Override
    public int getItemCount() {
        return operatorsModels.size();
    }


    //calling all the references of items of layout
    public class ArtificialJsonViewHolder extends RecyclerView.ViewHolder {
        public ImageView circleImageView;
        public TextView textViewId, textViewUser, textViewName, textViewWho;
        TextView carrierName;

        public ArtificialJsonViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.example_image);
            carrierName = itemView.findViewById(R.id.carrier_name);



        }
    }
}