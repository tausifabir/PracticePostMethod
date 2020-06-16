package com.example.cricketapiretrofit.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricketapiretrofit.Adapter.OperatorsAdapter;
import com.example.cricketapiretrofit.Model.OperatorsModel;
import com.example.cricketapiretrofit.R;

import java.util.ArrayList;


public class OperatorFragment extends Fragment implements OperatorsAdapter.OnItemClickListner{



    private RecyclerView operatorRecycler;
    private OperatorsAdapter operatorsAdapter;
    private ArrayList<OperatorsModel> operatorsModels;

    public OperatorFragment() {
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
        return inflater.inflate(R.layout.fragment_choose, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        operatorRecycler = view.findViewById(R.id.frag_operatortRV);
        operatorRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        operatorsModels = new ArrayList<>();

        setOperator();
    }


    private void setOperator() {

        operatorsModels.add(new OperatorsModel(R.drawable.airtel,"Airtel","4"));
        operatorsModels.add(new OperatorsModel(R.drawable.banglalink,"Banglalink","3"));
        operatorsModels.add(new OperatorsModel(R.drawable.grameenphone,"Grameenphone","1"));
        //operatorsModels.add(new OperatorsModel(R.drawable.robi,"Robi","2"));
        //operatorsModels.add(new OperatorsModel(R.drawable.teletalk,"Teletalk","5"));
        operatorsAdapter = new OperatorsAdapter(getContext(), operatorsModels);
        operatorsAdapter.setOnItemClickListener(this);
        operatorRecycler.setAdapter(operatorsAdapter);
    }

    @Override
    public void onItemClick(int position) {


        OperatorsModel clickeditem = operatorsModels.get(position);
        Bundle bundle = new Bundle();
        String id = clickeditem.getOperatorId();
        bundle.putString("id",id);

        OperatorPackageFragment operatorPackageFragment = new OperatorPackageFragment();
        operatorPackageFragment.setArguments(bundle);

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.viewPagerID,operatorPackageFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        Toast.makeText(getContext(), "Clicked "+operatorsModels.get(position).getOperatorName(), Toast.LENGTH_SHORT).show();
    }
}