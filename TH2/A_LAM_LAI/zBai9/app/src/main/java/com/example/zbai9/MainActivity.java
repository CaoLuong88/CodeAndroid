package com.example.zbai9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvmonhoc;
    EditText ettenmonhoc;
    Button btthem, btcapnhat, btxoa, btreset;
    ArrayList<String> mangmonhoc;
    ArrayAdapter<String> chuyendoi;
    int muclucduocchon = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvmonhoc = findViewById(R.id.lv_subjects);
        ettenmonhoc = findViewById(R.id.et_subject_name);
        btthem = findViewById(R.id.btn_add);
        btcapnhat = findViewById(R.id.btn_update);
        btxoa = findViewById(R.id.btn_delete);
        btreset = findViewById(R.id.btn_reset);

        mangmonhoc = new ArrayList<>();
        mangmonhoc.add("mang");
        mangmonhoc.add("mang mat tinh");
        mangmonhoc.add("lap trinh");

        chuyendoi = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mangmonhoc);
        lvmonhoc.setAdapter(chuyendoi);
        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                muclucduocchon=position;
                String tenmonhoc=mangmonhoc.get(position);
                ettenmonhoc.setText(tenmonhoc);
            }
        });

        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ettenmonhoc.setText("");
                muclucduocchon = -1;
            }
        });
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenmonhoc = ettenmonhoc.getText().toString();
                if (tenmonhoc.isEmpty()) {
                    Toast.makeText(MainActivity.this, "nhap ten mon hoc", Toast.LENGTH_LONG).show();

                } else {
                    mangmonhoc.add(tenmonhoc);
                    chuyendoi.notifyDataSetChanged();
                    ettenmonhoc.setText("");
                    Toast.makeText(MainActivity.this, "Them ten mon hoc thanh cong", Toast.LENGTH_LONG).show();

                }
            }
        });
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (muclucduocchon == -1) {
                    Toast.makeText(MainActivity.this, "chon dong can sua", Toast.LENGTH_LONG).show();
                } else {
                    String tenmonhoc = ettenmonhoc.getText().toString();
                    if (tenmonhoc.isEmpty()) {
                        Toast.makeText(MainActivity.this, "sua ten mon hoc", Toast.LENGTH_LONG).show();
                    } else {
                        mangmonhoc.set(muclucduocchon, tenmonhoc);
                        chuyendoi.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "cap nhat mon hoc thanh cong", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (muclucduocchon == -1) {
                    Toast.makeText(MainActivity.this, "chon mon hoc can xoa", Toast.LENGTH_LONG).show();

                }else {
                    mangmonhoc.remove(muclucduocchon);
                    chuyendoi.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this,"xoa mon hoc thanh cong",Toast.LENGTH_LONG).show();
                    muclucduocchon=-1;
                }
            }
        });
    }
}