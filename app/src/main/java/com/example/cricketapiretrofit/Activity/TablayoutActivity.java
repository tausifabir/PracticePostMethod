package com.example.cricketapiretrofit.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.example.cricketapiretrofit.Fragments.OperatorFragment;
import com.example.cricketapiretrofit.Fragments.TransferReportFragment;
import com.example.cricketapiretrofit.R;
import com.google.android.material.tabs.TabLayout;


public class TablayoutActivity extends AppCompatActivity {

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
}