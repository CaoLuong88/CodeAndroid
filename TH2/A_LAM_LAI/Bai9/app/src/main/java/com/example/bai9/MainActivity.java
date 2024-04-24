package com.example.bai9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvmonhoc;
    EditText ettenmonhoc;
    Button btthem,btcapnhat,btxoa,btreset;
    ArrayList<String> monhoc;
    ArrayAdapter<String> chuyendoi;
    int muclucduocchon=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvmonhoc=findViewById(R.id.lv_subjects);
        ettenmonhoc=findViewById(R.id.et_subject_name);
        btthem=findViewById(R.id.btn_add);
        btcapnhat=findViewById(R.id.btn_update);
        btreset=findViewById(R.id.btn_reset);
        btxoa=findViewById(R.id.btn_delete);

        monhoc=new ArrayList<>();
        monhoc.add("lap trinh");
        monhoc.add("C");
        monhoc.add("mang");

        chuyendoi=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,monhoc);
        lvmonhoc.setAdapter(chuyendoi);

        //khoi tao gia tri mac dinh
        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ettenmonhoc.setText("");
                muclucduocchon=-1;
            }
        });
        //them du lieu vao listview
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenmonhoc=ettenmonhoc.getText().toString();
                if(tenmonhoc.isEmpty()){
                    Toast.makeText(MainActivity.this,"nhap ten mon hoc",Toast.LENGTH_LONG).show();

                }else {
                    monhoc.add(tenmonhoc);
                    chuyendoi.notifyDataSetChanged();
                    ettenmonhoc.setText("");
                    Toast.makeText(MainActivity.this,"Them ten mon hoc thanh cong",Toast.LENGTH_LONG).show();

                }
            }
        });
        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                muclucduocchon= position;
                String tenmonhoc=monhoc.get(position);
                ettenmonhoc.setText(tenmonhoc);
            }
        });
        //cap nhat du lieu trong listview
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (muclucduocchon==-1){
                    Toast.makeText(MainActivity.this,"chon mon can sua",Toast.LENGTH_LONG).show();
                }else {
                    String tenmonhoc=ettenmonhoc.getText().toString();
                    if(tenmonhoc.isEmpty()){
                        Toast.makeText(MainActivity.this,"nhap ten mon hoc",Toast.LENGTH_LONG).show();
                    }else {
                        monhoc.set(muclucduocchon,tenmonhoc);
                        chuyendoi.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,"cap nhat mon hoc thanh cong",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        // xoa du lieu trong listview
        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(muclucduocchon==-1){
                    Toast.makeText(MainActivity.this,"chon mon hoc can xoa",Toast.LENGTH_LONG).show();
                }else {
                    monhoc.remove(muclucduocchon);
                    chuyendoi.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,"xoa mon hoc thanh cong",Toast.LENGTH_LONG).show();
                    muclucduocchon=-1;
                }
            }
        });
    }
}