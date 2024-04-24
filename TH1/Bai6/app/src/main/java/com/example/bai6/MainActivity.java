package com.example.bai6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Login = findViewById(R.id.button22);
            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dangNhap();
                }
            });
        }
        public void dangNhap(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bạn Đã Đăng Nhập Thành Công");
            AlertDialog dialog = builder.create();
            dialog.show();

        }


}