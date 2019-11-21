package com.m.sofiane.mynews.controler.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.m.sofiane.mynews.controler.fragment.TabTopFragment;
import com.m.sofiane.mynews.controler.fragment.TabMostFragment;
import com.m.sofiane.mynews.controler.fragment.TabSportFragment;

/**
 * created by Sofiane M. 20/06/2019
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager mFm) {
        super(mFm);
    }

    private final TabTopFragment tabOne = new TabTopFragment();
    private final TabMostFragment tabTwo = new TabMostFragment();
    private final TabSportFragment tabThree = new TabSportFragment();

    @Override
    public String getPageTitle (int position) {
        switch (position) {

            case 0:
                return "TOP STORIES";

            case 1:
                return "MOST POPULAR";

            case 2:
                return "SPORTS";

            default:
                return "";
    }}

    @Override
    public Fragment getItem(int i) {
        switch (i) {

            case 0:
                return tabOne;

            case 1:
                return tabTwo;

            case 2:
                return tabThree;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}