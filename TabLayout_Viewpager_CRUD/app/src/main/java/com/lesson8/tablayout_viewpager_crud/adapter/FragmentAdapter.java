package com.lesson8.tablayout_viewpager_crud.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lesson8.tablayout_viewpager_crud.fragment.FragmentAdd;
import com.lesson8.tablayout_viewpager_crud.fragment.FragmentSearch;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int numPage=2;

    public FragmentAdapter(@NonNull FragmentManager fm, int num) {
        super(fm, num);
        this.numPage=num;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentAdd();
            case 1:
                return new FragmentSearch();
            default:
                return new FragmentAdd();
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }
}
