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

    private ListView lvSubjects;
    private EditText etSubjectName;
    private Button btnAdd,btnUpdate,btnDelete,btnReset;
    private ArrayList<String> subjects;
    private ArrayAdapter<String> adapter;
    private int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSubjects = findViewById(R.id.lv_subjects);
        etSubjectName = findViewById(R.id.et_subject_name);
        btnAdd=findViewById(R.id.btn_add);
        btnUpdate=findViewById(R.id.btn_update);
        btnDelete=findViewById(R.id.btn_delete);
        btnReset=findViewById(R.id.btn_reset);

        subjects = new ArrayList<>();
        subjects.add("Lập trình C/C++");
        subjects.add("Lập trình trực quan");
        subjects.add("Công nghệ Java");
        subjects.add("Lập trình mạng");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        lvSubjects.setAdapter(adapter);

        // Khởi tạo lại giá trị mặc định
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSubjectName.setText("");
                selectedIndex = -1;
            }
        });

        // Thêm dữ liệu vào listview
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjectName = etSubjectName.getText().toString();
                if (subjectName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên môn học!", Toast.LENGTH_SHORT).show();
                } else {
                    subjects.add(subjectName);
                    adapter.notifyDataSetChanged();
                    etSubjectName.setText("");
                    Toast.makeText(MainActivity.this, "Thêm môn học thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý khi click vào item trong listview
        lvSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
                String subjectName = subjects.get(position);
                etSubjectName.setText(subjectName);
            }
        });

        // Cập nhật dữ liệu trong listview
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex == -1) {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn môn học cần sửa!", Toast.LENGTH_SHORT).show();
                } else {
                    String subjectName = etSubjectName.getText().toString();
                    if (subjectName.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập tên môn học!", Toast.LENGTH_SHORT).show();
                    } else {
                        subjects.set(selectedIndex, subjectName);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Cập nhật môn học thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Xóa dữ liệu khỏi listview
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex == -1) {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn môn học cần xóa!", Toast.LENGTH_SHORT).show();
                } else {
                    subjects.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Xóa môn học thành công!", Toast.LENGTH_SHORT).show();
                    selectedIndex = -1;
                }
            }
        });
    }
}
