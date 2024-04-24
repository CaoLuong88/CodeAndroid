package com.example.thu;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSubject, editTextRoom, editTextDay;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSubject = findViewById(R.id.editTextSubject);
        editTextRoom = findViewById(R.id.editTextRoom);
        editTextDay = findViewById(R.id.editTextDay);
        textViewInfo = findViewById(R.id.textViewInfo);
    }

    public void register(View view) {
        String subject = editTextSubject.getText().toString();
        String room = editTextRoom.getText().toString();
        String day = editTextDay.getText().toString();

        // Hiển thị thông tin đã nhập trong TextView
        String info = "Tên môn học: " + subject + "\nPhòng học: " + room + "\nThứ: " + day;
        textViewInfo.setText(info);
    }
}
