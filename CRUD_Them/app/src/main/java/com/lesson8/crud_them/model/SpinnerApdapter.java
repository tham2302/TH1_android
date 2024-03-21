package com.lesson8.crud_them.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lesson8.crud_them.R;

public class SpinnerApdapter extends BaseAdapter {
    private String[] imgs = {"Viet Nam", "Lao", "Campuchia"};
    private Context context;

    public SpinnerApdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_text, viewGroup, false);
        TextView img = item.findViewById(R.id.img);
        img.setText(imgs[position]);
        return item;
    }
}
