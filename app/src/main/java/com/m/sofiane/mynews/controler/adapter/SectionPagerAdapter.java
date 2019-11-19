package com.m.sofiane.mynews.controler.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.m.sofiane.mynews.controler.fragment.tab1_fragment;
import com.m.sofiane.mynews.controler.fragment.tab2_fragment;
import com.m.sofiane.mynews.controler.fragment.tab3_fragment;

/**
 * created by Sofiane M. 20/06/2019
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager mFm) {
        super(mFm);
    }

    private final tab1_fragment tabOne = new tab1_fragment();
    private final tab2_fragment tabTwo = new tab2_fragment();
    private final tab3_fragment tabThree = new tab3_fragment();

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