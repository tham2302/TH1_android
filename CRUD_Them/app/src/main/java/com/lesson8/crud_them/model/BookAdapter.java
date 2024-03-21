package com.lesson8.crud_them.model;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lesson8.crud_them.R;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<com.lesson8.crud_them.model.BookAdapter.BookViewHolder> {
    private Context context;
    private List<Book> mlist;
    private List<Book> listBackup;
    private BookItemListener mBookItem;

    public BookAdapter(Context context) {
        this.context = context;
        mlist = new ArrayList<>();
        listBackup = new ArrayList<>();
    }

    public List<Book> getBackup() {
        return listBackup;
    }

    public void setClickListener(BookItemListener mCatItem) {
        this.mBookItem = mCatItem;
    }

    public Book getItem(int position) {
        return mlist.get(position);
    }

    public void filterList(List<Book> filterlist) {
        mlist = filterlist;
        notifyDataSetChanged();
        ;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Book book = mlist.get(position);
        if (book == null)
            return;
        holder.tenSach.setText(book.getTenSach());
        holder.ngaySinh.setText(book.getNgayXuatBan());
        holder.quocTich.setText(book.getQuocTich());
        if (book.isLaNam() == true) {
            holder.img.setImageResource(R.drawable.img_nam);
        } else {
            holder.img.setImageResource(R.drawable.img_nu);
        }
        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo xoá");
                builder.setMessage("Bạn có chắc chắn muốn xoá " + book.getTenSach() + " không?");
                builder.setIcon(R.drawable.img);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listBackup.remove(position);
                        mlist.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mlist != null)
            return mlist.size();
        else
            return 0;
    }

    public void add(Book c) {
        mlist.add(c);
        listBackup.add(c);
        notifyDataSetChanged();
    }

    public void update(int position, Book c) {
        mlist.set(position, c);
        listBackup.set(position, c);
        notifyDataSetChanged();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tenSach;
        private TextView ngaySinh;
        private TextView quocTich;
        private ImageView img;
        private Button btRemove;

        public BookViewHolder(@NonNull View view) {
            super(view);
            tenSach = view.findViewById(R.id.tenSach);
            ngaySinh = view.findViewById(R.id.ngaySinh);
            quocTich = view.findViewById(R.id.quocTich);
            img = view.findViewById(R.id.img);
            btRemove = view.findViewById(R.id.btRemove);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mBookItem != null)
                mBookItem.onItemClick(view, getAdapterPosition());
        }
    }
}