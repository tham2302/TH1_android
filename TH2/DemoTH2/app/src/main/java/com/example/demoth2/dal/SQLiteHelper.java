package com.example.demoth2.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.demoth2.model.ItemDanhSach;
import com.example.demoth2.model.ItemDanhSach;
import com.example.demoth2.model.ItemThongTin;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="kiemtra.db";
    private static int DATABASE_VERSION = 1;
    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE sach("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "ten TEXT,tacgia TEXT,ngay TEXT,gio TEXT," +
                "hoc INT, cntt INT, vt INT, dt INT," +
                "gia INT)";
        db.execSQL(sql);
        String sql_1="CREATE TABLE sachyeu("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "img TEXT,ten TEXT,mota TEXT)";
        db.execSQL(sql_1);


//        insert

        String in="insert into sachyeu(img, ten, mota ) values" +
                "('https://th.bing.com/th/id/OIP.rla28wTwu7gQto6H6YYlIQHaKg?w=122&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7','doraemon', 'truyen tranh')," +
                "('https://th.bing.com/th/id/OIP.t8bQc-uFXhCOxRcWrYf9HQHaHa?w=184&h=184&c=7&r=0&o=5&dpr=1.3&pid=1.7','pokemon', 'POkeMon')";

        db.execSQL(in);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    //add
    public  long addItem(ItemDanhSach i){
        ContentValues values=new ContentValues();
        values.put("ten",i.getTen());
        values.put("tacgia",i.getTacgia());
        values.put("ngay",i.getNxb());
        values.put("gio",i.getGio());
        values.put("hoc", i.isHoc() ? 1: 0);
        values.put("cntt", i.isCNTT() ? 1: 0);
        values.put("vt", i.isVT() ? 1: 0);
        values.put("dt", i.isDT() ? 1: 0);
        values.put("gia",i.getGia());
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        return sqLiteDatabase.insert("sach",null,values);
    }

    public int update(ItemDanhSach i){
        ContentValues values=new ContentValues();
        values.put("ten",i.getTen());
        values.put("tacgia",i.getTacgia());
        values.put("ngay",i.getNxb());
        values.put("gio",i.getGio());
        values.put("hoc", i.isHoc() ? 1: 0);
        values.put("cntt", i.isCNTT() ? 1: 0);
        values.put("vt", i.isVT() ? 1: 0);
        values.put("dt", i.isDT() ? 1: 0);
        values.put("gia",i.getGia());
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        String whereClause="id= ?";
        String[] whereArgs={Integer.toString(i.getId())};
        return sqLiteDatabase.update("sach",values,whereClause,whereArgs);
    }
    //delete
    public int delete(int id){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        String whereClause="id= ?";
        String[] whereArgs={Integer.toString(id)};
        return sqLiteDatabase.delete("sach",whereClause,whereArgs);
    }

    public List<ItemDanhSach>getAll(){
        List<ItemDanhSach>list=new ArrayList<>();
        SQLiteDatabase st=getReadableDatabase();
        String order="ngay DESC";
        Cursor rs=st.query("sach",null,null
                ,null,null,null,order);
        while (rs!=null&& rs.moveToNext()){
            int id=rs.getInt(0);
            String ten=rs.getString(1);
            String tacgia=rs.getString(2);
            String nxb=rs.getString(3);
            String gio=rs.getString(4);
            int hoc=rs.getInt(5);
            int cntt=rs.getInt(6);
            int vt=rs.getInt(7);
            int dt=rs.getInt(8);
            int rate=rs.getInt(9);
            int gia=rs.getInt(10);
            boolean ehoc, ecntt, evt, edt;
            boolean etracuu=true;
            if(hoc==1){
                ehoc=true;
                etracuu=false;
            }
            else{
                ehoc=false;
                etracuu=true;
            }
            if(cntt==1){
                ecntt=true;
            } else ecntt=false;
            if(vt==1){
                evt=true;
            }else evt=false;
            if(dt==1){
                edt=true;
            }else edt=false;
            list.add(new ItemDanhSach(id,ten,tacgia,nxb,gio,ehoc,etracuu, ecntt, evt,edt,rate,gia));
        }
        return list;
    }

    public ItemDanhSach getCaSi(String name){
        String whereClause="ten like ?";
        String[] whereArgs={name};
        SQLiteDatabase st= getReadableDatabase();
        Cursor rs=st.query("sach",null,whereClause,whereArgs,null,null,null);
        if (rs!=null){
            int id=rs.getInt(0);
            String ten=rs.getString(1);
            String tacgia=rs.getString(2);
            String nxb=rs.getString(3);
            String gio=rs.getString(4);
            int hoc=rs.getInt(5);
            int cntt=rs.getInt(6);
            int vt=rs.getInt(7);
            int dt=rs.getInt(8);
            int rate=rs.getInt(9);
            int gia=rs.getInt(10);
            boolean ehoc, ecntt, evt, edt;
            boolean etracuu=true;
            if(hoc==1){
                ehoc=true;
                etracuu=false;
            }
            else{
                ehoc=false;
                etracuu=true;
            }
            if(cntt==1){
                ecntt=true;
            } else ecntt=false;
            if(vt==1){
                evt=true;
            }else evt=false;
            if(dt==1){
                edt=true;
            }else edt=false;
            return new ItemDanhSach(id,ten,tacgia,nxb,gio,ehoc,etracuu, ecntt, evt,edt,rate,gia);
        }
        else
            return null;
    }

    //lay cac item theo date
    public List<ItemDanhSach> getByDate(String date){
        List<ItemDanhSach>list=new ArrayList<>();
        String whereClause="ngay like ?";
        String[] whereArgs={date};
        SQLiteDatabase st= getReadableDatabase();
        Cursor rs=st.query("sach",null,whereClause,whereArgs,null,null,null);
        while (rs!=null&& rs.moveToNext()){
            int id=rs.getInt(0);
            String ten=rs.getString(1);
            String tacgia=rs.getString(2);
            String nxb=rs.getString(3);
            String gio=rs.getString(4);
            int hoc=rs.getInt(5);
            int cntt=rs.getInt(6);
            int vt=rs.getInt(7);
            int dt=rs.getInt(8);
            int rate=rs.getInt(9);
            int gia=rs.getInt(10);
            boolean ehoc, ecntt, evt, edt;
            boolean etracuu=true;
            if(hoc==1){
                ehoc=true;
                etracuu=false;
            }
            else{
                ehoc=false;
                etracuu=true;
            }
            if(cntt==1){
                ecntt=true;
            } else ecntt=false;
            if(vt==1){
                evt=true;
            }else evt=false;
            if(dt==1){
                edt=true;
            }else edt=false;
            list.add(new ItemDanhSach(id,ten,tacgia,nxb,gio,ehoc,etracuu, ecntt, evt,edt,rate,gia));
        }
        return list;
    }
    //update

    public List<ItemDanhSach> searchByName(String key){
        List<ItemDanhSach>list=new ArrayList<>();
        String whereClause="ten like ?";
        String[] whereArgs={"%"+key+"%"};
        SQLiteDatabase st= getReadableDatabase();
        Cursor rs=st.query("sach",null,whereClause,whereArgs,null,null,null);
        while (rs!=null&& rs.moveToNext()){
            int id=rs.getInt(0);
            String ten=rs.getString(1);
            String tacgia=rs.getString(2);
            String nxb=rs.getString(3);
            String gio=rs.getString(4);
            int hoc=rs.getInt(5);
            int cntt=rs.getInt(6);
            int vt=rs.getInt(7);
            int dt=rs.getInt(8);
            int rate=rs.getInt(9);
            int gia=rs.getInt(10);
            boolean ehoc, ecntt, evt, edt;
            boolean etracuu=true;
            if(hoc==1){
                ehoc=true;
                etracuu=false;
            }
            else{
                ehoc=false;
                etracuu=true;
            }
            if(cntt==1){
                ecntt=true;
            } else ecntt=false;
            if(vt==1){
                evt=true;
            }else evt=false;
            if(dt==1){
                edt=true;
            }else edt=false;
            list.add(new ItemDanhSach(id,ten,tacgia,nxb,gio,ehoc,etracuu, ecntt, evt,edt,rate,gia));
        }
        return list;
    }
    public List<ItemDanhSach> searchByLoai(String category){
        List<ItemDanhSach>list=new ArrayList<>();
        String whereClause="nhaxuatban like ?";
        String[] whereArgs={category};
        SQLiteDatabase st= getReadableDatabase();
        Cursor rs=st.query("sach",null,whereClause,whereArgs,null,null,null);
        while (rs!=null&& rs.moveToNext()){
            int id=rs.getInt(0);
            String ten=rs.getString(1);
            String tacgia=rs.getString(2);
            String nxb=rs.getString(3);
            String gio=rs.getString(4);
            int hoc=rs.getInt(5);
            int cntt=rs.getInt(6);
            int vt=rs.getInt(7);
            int dt=rs.getInt(8);
            int rate=rs.getInt(9);
            int gia=rs.getInt(10);
            boolean ehoc, ecntt, evt, edt;
            boolean etracuu=true;
            if(hoc==1){
                ehoc=true;
                etracuu=false;
            }
            else{
                ehoc=false;
                etracuu=true;
            }
            if(cntt==1){
                ecntt=true;
            } else ecntt=false;
            if(vt==1){
                evt=true;
            }else evt=false;
            if(dt==1){
                edt=true;
            }else edt=false;
            list.add(new ItemDanhSach(id,ten,tacgia,nxb,gio,ehoc,etracuu, ecntt, evt,edt,rate,gia));
        }
        return list;
    }
    public List<ItemDanhSach> searchByDate(String from, String to){
        List<ItemDanhSach>list=new ArrayList<>();
        String whereClause="ngay BETWEEN ? AND ? ";
        String[] whereArgs={from.trim(),to.trim()};
        SQLiteDatabase st= getReadableDatabase();
        Cursor rs=st.query("sach",null,whereClause,whereArgs,null,null,null);
        while (rs!=null&& rs.moveToNext()){
            int id=rs.getInt(0);
            String ten=rs.getString(1);
            String tacgia=rs.getString(2);
            String nxb=rs.getString(3);
            String gio=rs.getString(4);
            int hoc=rs.getInt(5);
            int cntt=rs.getInt(6);
            int vt=rs.getInt(7);
            int dt=rs.getInt(8);
            int rate=rs.getInt(9);
            int gia=rs.getInt(10);
            boolean ehoc, ecntt, evt, edt;
            boolean etracuu=true;
            if(hoc==1){
                ehoc=true;
                etracuu=false;
            }
            else{
                ehoc=false;
                etracuu=true;
            }
            if(cntt==1){
                ecntt=true;
            } else ecntt=false;
            if(vt==1){
                evt=true;
            }else evt=false;
            if(dt==1){
                edt=true;
            }else edt=false;
            list.add(new ItemDanhSach(id,ten,tacgia,nxb,gio,ehoc,etracuu, ecntt, evt,edt,rate,gia));
        }
        return list;
    }

    public long addThongTin(ItemThongTin i){
        ContentValues values=new ContentValues();
        values.put("img",i.getAnh());
        values.put("ten",i.getTen());
        values.put("mota",i.getNhanxet());
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        return sqLiteDatabase.insert("sachyeu",null,values);
    }

    public List<ItemThongTin>getAllThongTin(){
        List<ItemThongTin>list=new ArrayList<>();
        SQLiteDatabase st=getReadableDatabase();
        Cursor rs=st.query("sachyeu",null,null
                ,null,null,null,null);
        while (rs!=null&& rs.moveToNext()){
            int id=rs.getInt(0);
            String img=rs.getString(1);
            String ten=rs.getString(2);
            String des=rs.getString(3);
            list.add(new ItemThongTin(id,img,ten,des));
        }
        return list;
    }


    public ItemThongTin getItemCasi(String name){
        String whereClause="ten like ?";
        String[] whereArgs={name};
        SQLiteDatabase st= getReadableDatabase();
        Cursor rs=st.query("sachyeu",null,whereClause,whereArgs,null,null,null);
        if (rs!=null){
            int id=rs.getInt(0);
            String img=rs.getString(1);
            String ten=rs.getString(2);
            String mota=rs.getString(3);
            return new ItemThongTin(id,img,ten,mota);
        }
        else
            return null;
    }

}
