package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public Button phepTinh,thongTin,thoat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        phepTinh = findViewById(R.id.bt_phepTinh);
        thongTin=findViewById(R.id.bt_thongTin);
        thoat=findViewById(R.id.btthoat);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        phepTinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhepTinh.class);
                startActivity(intent);
            }
        });

        thongTin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThongTinActivity.class);
                startActivity(intent);
            }
        });
    }
}