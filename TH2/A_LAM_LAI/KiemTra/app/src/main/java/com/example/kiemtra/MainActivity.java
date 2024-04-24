package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button pheptinh,thongtin,quaylai,lvcoban,lvnangcao;
    ArrayList<MyTodo> listTodo; //Mảng dữ liệu
    ListViewNangCaoActivity adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pheptinh=findViewById(R.id.bt_phepTinh);
        thongtin=findViewById(R.id.bt_thongTin);
        quaylai = findViewById(R.id.btthoat);
        lvcoban=findViewById(R.id.btLVCoBan);
        lvnangcao=findViewById(R.id.btLVNangCao);

        pheptinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PhepTinhActivity.class);
                startActivity(intent);
            }
        });
        thongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ThongTinActivity.class);
                startActivity(intent);
            }
        });
        lvcoban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListViewCoBanActivity.class);
                startActivity(intent);
            }
        });
        lvnangcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListViewNangCaoActivity.class);
                startActivity(intent);
            }
        });

        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.todo_menu, menu);
        return true;
    }
}