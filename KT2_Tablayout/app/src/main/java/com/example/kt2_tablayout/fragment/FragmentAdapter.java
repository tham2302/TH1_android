package com.example.kt2_tablayout.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class FragmentAdapter extends FragmentPagerAdapter {
    private int pageNumber;
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentDanhSach danhSach=new FragmentDanhSach();
                return danhSach;
            case 1:
                FragmentThongTin thongTin= new FragmentThongTin();
                return thongTin;
            case 2:
                FragmentTimKiemThongKe timKiemThongKe=new FragmentTimKiemThongKe();
                return timKiemThongKe;
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
                return "DANH SÁCH";
            case 1:
                return "THÔNG TIN";
            case 2:
                return "TÌM KIẾM";
        }
        return null;
    }
}
