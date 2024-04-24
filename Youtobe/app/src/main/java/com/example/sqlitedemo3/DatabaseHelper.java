package com.example.sqlitedemo3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class DatabaseHelper extends SQLiteOpenHelper{
        public static final String TABLE_CUSTOMERS = "Khachhang";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";

        public DatabaseHelper(@Nullable Context context) {
                super(context, "khachhang.db", null, 1);
                }


        public void onCreate(SQLiteDatabase db) {
                String creatTable="CREATE TABLE Khachhang ("+
                "id int ,"+
                "name text,"+
                "age int);";
                db.execSQL(creatTable);

                }


        public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
        public boolean addOne(KhachHangModel kh)
                {
                SQLiteDatabase db= this.getWritableDatabase();
                ContentValues cv= new ContentValues();
                cv.put("name",kh.getName());
                cv.put("age",kh.getAge());

                long kq=db.insert("Khachhang",null,cv);
                if (kq<1) {
                return  false;
                }
                return true;

                }
        public void ResetDB() {
                ArrayList<KhachHangModel> listview = new ArrayList<>();
                String query = "Delete FROM Khachhang";
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL(query);

                }
    public ArrayList <KhachHangModel> getAll()
    {
        ArrayList<KhachHangModel> listview= new ArrayList<>();
        String query="SELECT * FROM Khachhang";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr=db.rawQuery(query,null);
        if (cr.moveToFirst())
        {
            do{
                int id=cr.getInt(0);
                String name=cr.getString(1);
                int age=cr.getInt(2);
                KhachHangModel item=new KhachHangModel();
                item.setAge(age);
                item.setName(name);
                item.setId(id);
                listview.add(item);
            }
            while (cr.moveToNext());
        }
        else {

        }
        return listview;
    }
}
//public class DatabaseHelper extends SQLiteOpenHelper{
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, "khachhang.db", null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String creatTable="CREATE TABLE Khachhang ("+
//                "id text PRIMARY KEY AUTOINCREMENT,"+
//                "name text,"+
//                "age int);";
//        db.execSQL(creatTable);
//
//    }
//
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
//    public boolean addOne(KhachHangModel kh)
//    {
//        SQLiteDatabase db= this.getWritableDatabase();
//        ContentValues cv= new ContentValues();
//        cv.put("name",kh.getName());
//        cv.put("age",kh.getAge());
//
//        long kq=db.insert("Khachhang",null,cv);
//        if (kq<1) {
//            return  false;
//        }
//        return true;
//
//    }
//    public void ResetDB() {
//        ArrayList<KhachHangModel> listview = new ArrayList<>();
//        String query = "Delete FROM Khachhang";
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL(query);
//
//    }
//    public ArrayList <KhachHangModel> getAll()
//    {
//        ArrayList<KhachHangModel> listview= new ArrayList<>();
//        String query="SELECT * FROM Khachhang";
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cr=db.rawQuery(query,null);
//        if (cr.moveToFirst())
//        {
//            do{
//                int id=cr.getInt(0);
//                String name=cr.getString(1);
//                int age=cr.getInt(2);
//                KhachHangModel item=new KhachHangModel();
//                item.setAge(age);
//                item.setName(name);
//                item.setId(id);
//                listview.add(item);
//            }
//            while (cr.moveToNext());
//        }
//        else {
//
//        }
//        return listview;
//    }
//}
