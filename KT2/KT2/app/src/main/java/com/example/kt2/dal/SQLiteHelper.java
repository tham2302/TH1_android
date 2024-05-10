package com.example.kt2.dal;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.kt2.model.Ve;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "my_database";
    private static final int DATABASE_VERSION = 1;

    // Tên bảng và các cột
    public static final String TABLE_VE = "ve";
    public static final String COLUMN_ID = "ma";
    public static final String COLUMN_HO_TEN = "ho_ten";
    public static final String COLUMN_NOI_KHOI_HANH = "noi_khoi_hanh";
    public static final String COLUMN_NGAY_KHOI_HANH = "ngay_khoi_hanh";
    public static final String COLUMN_HANH_LY = "hanh_ly";
    public static final String COLUMN_THUOC = "thuoc";
    public static final String COLUMN_AN = "an";
    public static final String COLUMN_CAPHE = "caphe";

    // Câu lệnh tạo bảng
    private static final String DATABASE_CREATE = "create table "
            + TABLE_VE + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_HO_TEN
            + " text not null, " + COLUMN_NOI_KHOI_HANH + " text not null, "
            + COLUMN_NGAY_KHOI_HANH + " text not null, " + COLUMN_HANH_LY
            + " text not null, " + COLUMN_THUOC + " text not null, "
            + COLUMN_AN + " integer not null, " + COLUMN_CAPHE
            + " integer not null);";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VE);
        onCreate(db);
    }

    @SuppressLint("Range")
    public List<Ve> getAllVe() {
        List<Ve> ves = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_VE, null);

        if (cursor.moveToFirst()) {
            do {
                Ve ve = new Ve();
                ve.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                ve.setHoTen(cursor.getString(cursor.getColumnIndex(COLUMN_HO_TEN)));
                ve.setNoiKhoiHanh(cursor.getString(cursor.getColumnIndex(COLUMN_NOI_KHOI_HANH)));
                ve.setNgayKhoiHanh(cursor.getString(cursor.getColumnIndex(COLUMN_NGAY_KHOI_HANH)));
                ve.setKyGui(cursor.getInt(cursor.getColumnIndex(COLUMN_HANH_LY)) == 1);
                ve.setThuoc(cursor.getInt(cursor.getColumnIndex(COLUMN_THUOC)) == 1);
                ve.setAn(cursor.getInt(cursor.getColumnIndex(COLUMN_AN)) == 1);
                ve.setCaphe(cursor.getInt(cursor.getColumnIndex(COLUMN_CAPHE)) == 1);
                ves.add(ve);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return ves;
    }

    // Thêm một vé mới vào cơ sở dữ liệu
    public void addVe(Ve ve) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_HO_TEN, ve.getHoTen());
        values.put(COLUMN_NOI_KHOI_HANH, ve.getNoiKhoiHanh());
        values.put(COLUMN_NGAY_KHOI_HANH, ve.getNgayKhoiHanh());
        values.put(COLUMN_HANH_LY, ve.isKyGui() ? 1 : 0);
        values.put(COLUMN_THUOC, ve.isThuoc() ? 1 : 0);
        values.put(COLUMN_AN, ve.isAn() ? 1 : 0);
        values.put(COLUMN_CAPHE, ve.isCaphe() ? 1 : 0);
        db.insert(TABLE_VE, null, values);
        db.close();
    }

    public void deleteVe(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_VE, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Cập nhật một vé trong cơ sở dữ liệu theo ID
    public void updateVe(int id, Ve ve) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_HO_TEN, ve.getHoTen());
        values.put(COLUMN_NOI_KHOI_HANH, ve.getNoiKhoiHanh());
        values.put(COLUMN_NGAY_KHOI_HANH, ve.getNgayKhoiHanh());
        values.put(COLUMN_HANH_LY, ve.isKyGui() ? 1 : 0);
        values.put(COLUMN_THUOC, ve.isThuoc() ? 1 : 0);
        values.put(COLUMN_AN, ve.isAn() ? 1 : 0);
        values.put(COLUMN_CAPHE, ve.isCaphe() ? 1 : 0);
        db.update(TABLE_VE, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

}
