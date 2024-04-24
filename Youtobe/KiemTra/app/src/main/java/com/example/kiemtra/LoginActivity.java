package com.example.kiemtra;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username,et_password;
    private Button btnLogin,btthoat;
    protected void onCreate( Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_login);

        et_username= findViewById(R.id.et_username);
        et_password= findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btthoat=findViewById(R.id.btn_exit);
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (username.equals("admin") && password.equals("Admin123")) {
                    Toast.makeText(LoginActivity.this, "Đăng Nhâp Thành Công ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Sai tài khoản hoac mật khẩu ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

