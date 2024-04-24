package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewCoBanActivity extends AppCompatActivity {
    ListView lvcoban;
    Button btquaylai;
    ArrayList<String> mangmonhoc;
    ArrayAdapter<String> chuyendoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_co_ban);
        lvcoban=findViewById(R.id.lvCoBan);
        btquaylai=findViewById(R.id.btQuaylaiLVCB);

        mangmonhoc=new ArrayList<>();
        mangmonhoc.add("lap trinh");
        mangmonhoc.add("lap trinh mobile");
        mangmonhoc.add("lap trinh mmang");
        chuyendoi=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mangmonhoc);
        lvcoban.setAdapter(chuyendoi);
        btquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}