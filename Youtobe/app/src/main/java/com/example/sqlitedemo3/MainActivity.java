package com.example.sqlitedemo3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabAdd;
    ListView lstView;
    //private KhachHangAdaper adapter;
    //ArrayList<String> arrayName;
    public void InnitDB()
    {

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        databaseHelper.ResetDB();

        KhachHangModel item1=new KhachHangModel();
        item1.setName("Elise");
        item1.setAge(4);
        databaseHelper.addOne(item1);
    }
    private ArrayList<KhachHangModel> khachHangModelList;

    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        //InnitDB();
        lstView = (ListView) findViewById(R.id.ltView);
        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        khachHangModelList = databaseHelper.getAll();
        KhachHangAdapter khAdapter = new KhachHangAdapter(getApplicationContext(), khachHangModelList);
        lstView.setAdapter(khAdapter);
        this.setTitle("Danh sách khách hàng (" + khachHangModelList.size() + ")");
        khAdapter.notifyDataSetChanged();
    }
    public void fabAdd_click(View view)
    {
        Intent intent=new Intent(MainActivity.this,UpdateActivity.class);
        //String message = "";
        //intent.putExtra("Id", message);
        startActivity(intent);
    }


}