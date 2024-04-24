package com.example.bai8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
   ListView lvmonhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvmonhoc=findViewById(R.id.listDSMonHoc);

        String[] monhoc = {"01.Toán", "02.Lý", "03.Hóa", "04.Sinh", "05.Ngữ văn", "06.Lịch sử", "07.Địa lí"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, monhoc);
        lvmonhoc.setAdapter(adapter);
    }

}