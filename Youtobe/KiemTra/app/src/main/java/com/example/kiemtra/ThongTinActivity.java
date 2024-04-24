package com.example.kiemtra;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ThongTinActivity extends AppCompatActivity {
   Spinner spinnerkhoa;
    RadioGroup rgnamnu;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
        Button thoat = findViewById(R.id.btThoatThongTin);
        Button hienthi = findViewById(R.id.bt_HienThi);
        EditText hoten = findViewById(R.id.et_HoTen);
        EditText ngaysinh = findViewById(R.id.et_NgaySinh);
        rgnamnu=findViewById(R.id.rgNamNu);
        spinnerkhoa=findViewById(R.id.spKhoa);

        String[] dulieukhoa={"CNTT&TT","KINH TE" ,"NGOAI NGU"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,dulieukhoa);
        spinnerkhoa.setAdapter(adapter);

        hienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = hoten.getText().toString();
                String birthday = ngaysinh.getText().toString();
                String chonkhoa = spinnerkhoa.getSelectedItem().toString();
                int chonrdbid=rgnamnu.getCheckedRadioButtonId();
                RadioButton chonrdb=findViewById(chonrdbid);
                String gioitinh=chonrdb.getText().toString();



                AlertDialog.Builder builder = new AlertDialog.Builder(ThongTinActivity.this);
                builder.setTitle("Hien thi thong tin");
                builder.setMessage("Ho ten: " + name + "\nNgay sinh: " + birthday + "\nGioi tinh: "+gioitinh +"\nKhoa "+chonkhoa );
                builder.setPositiveButton("Dong", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}