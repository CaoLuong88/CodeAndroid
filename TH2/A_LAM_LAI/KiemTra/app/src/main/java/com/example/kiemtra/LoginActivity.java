package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edhocten,edmatkhau;
    Button btdangnhap,btthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edhocten=findViewById(R.id.et_username);
        edmatkhau=findViewById(R.id.et_password);
        btdangnhap=findViewById(R.id.btn_login);
        btthoat=findViewById(R.id.btn_exit);

        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten=edhocten.getText().toString();
                String matkhau=edmatkhau.getText().toString();
                if (hoten.equals("admin") && matkhau.equals("Admin123")){
                    Toast.makeText(LoginActivity.this,"Dang nhap thanh cong",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"sai ten hoac mat khau",Toast.LENGTH_LONG).show();

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