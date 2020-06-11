package com.example.cricketapiretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricketapiretrofit.Model.Profile;
import com.example.cricketapiretrofit.R;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileInfoViewHolder> {

    private Context context;
    private List<Profile> profileModelList;

    public ProfileAdapter(Context context, List<Profile> profileModelList) {
        this.context = context;
        this.profileModelList = profileModelList;
    }

    @NonNull
    @Override
    public ProfileInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.continent_row,parent,false);

        return new ProfileInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileInfoViewHolder holder, int position) {




        holder.profileTitle.setText(profileModelList.get(position).getTitle());
        holder.profileDetails.setText(profileModelList.get(position).getDetails());



    }

    @Override
    public int getItemCount() {
        return profileModelList.size();
    }


    public class ProfileInfoViewHolder extends RecyclerView.ViewHolder {


        private TextView profileTitle, profileDetails,profileDot;
        public ProfileInfoViewHolder(@NonNull View itemView) {
            super(itemView);

            profileTitle = itemView.findViewById(R.id.personInfoTV);
            profileDetails = itemView.findViewById(R.id.personShowTV);
            profileDot = itemView.findViewById(R.id.personDot);
        }
    }
}
