package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoGinActivity extends AppCompatActivity {
   EditText edtendangnhap,edmatkhau;
   Button btdangnhap,btthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lo_gin);

        edtendangnhap=findViewById(R.id.et_username);
        edmatkhau=findViewById(R.id.et_password);
        btdangnhap=findViewById(R.id.btn_login);
        btthoat=findViewById(R.id.btn_exit);

        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tendaangnhap=edtendangnhap.getText().toString();
                String matkhau=edmatkhau.getText().toString();
                if (tendaangnhap.equals("admin" )&& matkhau.equals("Admin") ){
                    Toast.makeText(LoGinActivity.this,"dang nhap thanh cong",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(LoGinActivity.this,MainActivity.class);
                startActivity(intent);
                }else {
                    Toast.makeText(LoGinActivity.this,"sai ten dang nhap hoac mat khau",Toast.LENGTH_LONG).show();
                }
            }
        });
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}