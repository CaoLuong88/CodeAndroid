package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

import android.widget.Toast;

import java.util.ArrayList;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {
    private EditText editTextSubject, editTextRoom, editTextDay;

    private Button  buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSubject = findViewById(R.id.editTextTextTenMH);
        editTextRoom = findViewById(R.id.editTextTextPH);
        editTextDay = findViewById(R.id.editTextTextT);

        buttonRegister = findViewById(R.id.btDK);
        TextView textViewResult = findViewById(R.id.textViewInfo);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextSubject.getText().toString();
                String classroom = editTextRoom.getText().toString();
                String day= editTextDay.getText().toString();
                textViewResult.setText ( "Tên môn học: " + name + "\nPhòng học: " + classroom +"\nThu: " +day);
            }
        });
    }
}