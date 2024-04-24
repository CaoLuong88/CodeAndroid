package com.example.bai8a;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private TextView tvListTitle;
    private ListView lvSubjects;
    private Button btnLogout,btnLogin;
    private ArrayList<String> subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        tvListTitle = findViewById(R.id.tv_list_title);
        lvSubjects = findViewById(R.id.lv_subjects);
        btnLogout = findViewById(R.id.btn_logout);
        btnLogin=findViewById(R.id.btn_login);

        subjects = new ArrayList<>();
        subjects.add("Lập trình C/C++");
        subjects.add("Lập trình trực quan");
        subjects.add("Công nghệ Java");
        subjects.add("Lập trình mạng");
        subjects.add("Tính toán song song");
        subjects.add("Thiết kế web");
        subjects.add("Lập trình web");
        subjects.add("Tin học đại cương");
        subjects.add("Thiết kế phần mềm");

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("admin") && password.equals("1")) {
                    // Hiển thị danh sách môn học
                    tvListTitle.setVisibility(View.VISIBLE);
                    lvSubjects.setVisibility(View.VISIBLE);
                    btnLogout.setVisibility(View.VISIBLE);

                    // Ẩn form đăng nhập
                    etUsername.setVisibility(View.GONE);
                    etPassword.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.GONE);

                    // Cập nhật dữ liệu cho ListView
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, subjects);
                    lvSubjects.setAdapter(adapter);
                } else {
                    // Hiển thị thông báo lỗi
                    Toast.makeText(MainActivity.this, "Tên đăng nhập hoặc mật khẩu sai!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
