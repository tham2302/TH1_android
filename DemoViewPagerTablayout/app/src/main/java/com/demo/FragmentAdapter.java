package com.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.demo.model.Fragment_Food;
import com.demo.model.Fragment_Movie;
import com.demo.model.Fragment_Travel;

public class FragmentAdapter extends FragmentPagerAdapter {
    private int pageNumber;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment_Food food = new Fragment_Food();
                return food;
            case 1:
                Fragment_Movie movie = new Fragment_Movie();
                return movie;
            case 2:
                Fragment_Travel travel = new Fragment_Travel();
                return travel;
        }
        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "FOOD";
            case 1:
                return "MOVIE";
            case 2:
                return "TRAVEL";

        }
        return null;
    }
}
