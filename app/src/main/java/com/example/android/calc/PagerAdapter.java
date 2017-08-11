package com.example.android.calc;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;


public class PagerAdapter extends FragmentPagerAdapter{
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int index)
    {
        switch (index)
        {
            case 0:
                return new CommonFragment();
            case 1:
                return new ScientificFragment();

        }

        return null;
    }

    @Override
    public int getCount()
    {
        return 2;
    }
}


