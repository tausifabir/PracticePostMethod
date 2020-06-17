package com.example.cricketapiretrofit.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cricketapiretrofit.Fragments.OperatorFragment;
import com.example.cricketapiretrofit.Fragments.OperatorPackageFragment;
import com.example.cricketapiretrofit.Fragments.TransferReportFragment;
import com.example.cricketapiretrofit.Interface.FragmentDataPass;
import com.example.cricketapiretrofit.Model.OperatorsModel;
import com.example.cricketapiretrofit.R;
import com.google.android.material.tabs.TabLayout;

import static android.view.View.VISIBLE;


public class TablayoutActivity extends AppCompatActivity implements FragmentDataPass {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        intwidget();

    }

    private void intwidget() {


        tabLayout = findViewById(R.id.tablayoutID);
        tabLayout.addTab(tabLayout.newTab().setText("Choose Operator"));
        tabLayout.addTab(tabLayout.newTab().setText("Transfer Report"));
        tabLayout.setTabTextColors(Color.WHITE,Color.RED);
        tabLayout.setSelectedTabIndicatorColor(Color.LTGRAY);
        viewPager = findViewById(R.id.viewPagerID);




        OperatorAdapter operatorAdapter = new OperatorAdapter(getSupportFragmentManager());
        viewPager.setAdapter(operatorAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


    @Override
    protected void onResume() {
        super.onResume();
        viewPager.setVisibility(VISIBLE);
        tabLayout.setVisibility(VISIBLE);
    }



    @Override
    public void getFragmentData(OperatorsModel operatorsModel) {

        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        String id = operatorsModel.getOperatorId();
        bundle.putString("id",id);

        OperatorPackageFragment operatorPackageFragment = new OperatorPackageFragment();
        operatorPackageFragment.setArguments(bundle);
        replaceFragment( operatorPackageFragment);
    }


    private class OperatorAdapter extends FragmentPagerAdapter {


        public OperatorAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0 :
                    return new OperatorFragment();
                case 1:
                    return new TransferReportFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerid, fragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        viewPager.setVisibility(View.GONE);
        tabLayout.setVisibility(View.GONE);

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        viewPager.setVisibility(VISIBLE);
        tabLayout.setVisibility(VISIBLE);
    }
}