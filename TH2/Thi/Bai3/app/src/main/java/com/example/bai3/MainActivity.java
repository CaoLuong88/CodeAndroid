package com.example.bai3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvMonHoc;
    private MonHocAdapter adapter;
    private List<MonHoc> monHocList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = findViewById(R.id.lvMonHoc);

        monHocList = new ArrayList<>();
        monHocList.add(new MonHoc("Toán", "MH001"));
        monHocList.add(new MonHoc("Lý", "MH002"));
        // Thêm các môn học khác vào danh sách

        adapter = new MonHocAdapter(this, monHocList);
        lvMonHoc.setAdapter(adapter);
    }
}
