package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShowText = findViewById(R.id.btnShowText);
        Button btnChangeText = findViewById(R.id.btnChangeText);

        // Sự kiện click cho button "Show Text"
        btnShowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị văn bản "Hello World" trên giao diện
                // (Giả sử có một TextView có id là txtDisplayText để hiển thị văn bản)
                TextView txtDisplayText = findViewById(R.id.txtDisplayText);
                txtDisplayText.setText("Anh Lương");

                // Ghi thông điệp "Hello World" vào LogCat
                Log.d(TAG, "Hello World");
            }
        });

        // Sự kiện click cho button "Change Text"
        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thay đổi văn bản từ "Hello World" thành "Khoa CNTT&TT" trên giao diện
                // và cập nhật vào LogCat
                TextView txtDisplayText = findViewById(R.id.txtDisplayText);
                txtDisplayText.setText("Anh Lương đẹp trai quá");

                // Xóa thông điệp "Hello World" trước đó trong LogCat
                Log.d(TAG, "Khoa CNTT&TT");
            }
        });
    }
}