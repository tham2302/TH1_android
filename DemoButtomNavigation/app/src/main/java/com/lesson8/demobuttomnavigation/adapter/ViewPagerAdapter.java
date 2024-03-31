package com.lesson8.demobuttomnavigation.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lesson8.demobuttomnavigation.fragment.FragmentCafe;
import com.lesson8.demobuttomnavigation.fragment.Fragment_Home;
import com.lesson8.demobuttomnavigation.fragment.Fragment_Noti;
import com.lesson8.demobuttomnavigation.fragment.Fragment_Search;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int numPage=4;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Fragment_Home();
            case 1: return new Fragment_Noti();
            case 2: return new Fragment_Search();
            case 3: return new FragmentCafe();
            default: return new Fragment_Home();
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }
}
