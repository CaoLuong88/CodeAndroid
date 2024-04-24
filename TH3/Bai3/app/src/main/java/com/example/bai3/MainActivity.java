package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edmalop,edtenlop,edsiso;
    Button btthem,btxoa,btcapnhat,bttruyvan;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edmalop=findViewById(R.id.edMaLop);
        edtenlop=findViewById(R.id.edTenLop);
        edsiso=findViewById(R.id.edSiSo);
        btcapnhat=findViewById(R.id.btCapNhat);
        btthem=findViewById(R.id.btThem);
        btxoa=findViewById(R.id.btXoa);
        bttruyvan=findViewById(R.id.btTruyVan);
        //tao listview
        lv=findViewById(R.id.lvDanhSach);
        mylist=new ArrayList<>();
        myadapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mylist);
        lv.setAdapter(myadapter);
        //tao va mo co so du lieu sqlite
        mydatabase=openOrCreateDatabase("qlsinhvien.db",MODE_PRIVATE,null);
        // tao table de chua du lieu
        try {
            String sql="CREATE TABLE tblop(maLop TEXT primary key,tenLop TEXT,siSo INTEGER)";
            mydatabase.execSQL(sql);
        }catch (Exception e){
            Log.e("loi","bang da ton tai");
        }
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop=edmalop.getText().toString();
                String tenlop=edtenlop.getText().toString();
                int siso= Integer.parseInt(edsiso.getText().toString());
                ContentValues myvalue=new ContentValues();
                myvalue.put("maLop",malop);
                myvalue.put("tenLop",tenlop);
                myvalue.put("siSo",siso);
                String msg="";
                if (mydatabase.insert("tblop",null,myvalue)==-1){
                    msg="loi them ko thanh cong";
                }else {
                    msg="them thanh cong";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        bttruyvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylist.clear();
                Cursor c=mydatabase.query("tblop",null,null,null,null,null,null);
                c.moveToNext();
                String dulieu="";
                while (c.isAfterLast()==false){
                    dulieu=c.getString(0)+" - "+c.getString(1)+" - "+c.getString(2);
                    c.moveToNext();
                    mylist.add(dulieu);
                }
                c.close();
                myadapter.notifyDataSetChanged();
            }
        });
        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edmalop.getText().toString();
                int n = mydatabase.delete("tblop","maLop = ?",new
                        String[]{malop});
                String msg ="";
                if (n == 0)
                {
                    msg = "ko xoa duoc";
                }
                else {
                    msg = n +" Xoa thanh cong";
                }
                Toast.makeText(MainActivity.this, msg,
                        Toast.LENGTH_SHORT).show();
            }
        });
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int siso = Integer.parseInt(edsiso.getText().toString());
                String malop = edmalop.getText().toString();
                ContentValues myvalue = new ContentValues();
                myvalue.put("siSo",siso);
                int n = mydatabase.update("tblop",myvalue,"maLop = ?",new
                        String[]{malop});
                String msg = "";
                if (n == 0)
                {
                    msg = "ko cap nhat duoc";
                }
                else {
                    msg = n+ " Cap nhat thanh cong";
                }
                Toast.makeText(MainActivity.this, msg,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}