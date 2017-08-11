package com.example.android.calc;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.design.widget.TabLayout;


import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.List;


import static com.example.android.calc.R.id.equation;
import static com.example.android.calc.R.id.solution;


public class MainActivity extends FragmentActivity implements CommonFragment.ChangeOpt,ScientificFragment.ChangeOpt2 {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CommonFragment mGment = new CommonFragment();
        mGment.setThis(this);

        ScientificFragment mSment = new ScientificFragment();
        mSment.setThis2(this);


        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.addFragment(mGment, "COMMON");
        adapter.addFragment(mSment, "SCIENTIFIC");

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);





    }


    @Override
    public void selectMain(String e) {

        TextView solution = (TextView) findViewById(R.id.solution);
        solution.setText(e);
    }

    @Override
    public void equateMain(String d) {
        TextView equation = (TextView) findViewById(R.id.equation);
        equation.setText(d);
    }

    @Override
    public void selectMain2(String e) {
        TextView solution = (TextView) findViewById(R.id.solution);
        solution.setText(e);
    }

    @Override
    public void equateMain2(String d) {
        TextView equation = (TextView) findViewById(R.id.equation);
        equation.setText(d);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}


