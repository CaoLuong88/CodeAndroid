package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText editTextSoA,editTextSoB,editTextKetQua;
    Button buttonThoat,buttonCong,buttonTru,buttonNhan,buttonChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextSoA = findViewById(R.id.editSoA);
        editTextSoB = findViewById(R.id.editSoB);
        editTextKetQua = findViewById(R.id.editKetQua);
        buttonThoat = findViewById(R.id.btThoat);
        buttonCong = findViewById(R.id.btCong);
        buttonTru = findViewById(R.id.btTru);
        buttonNhan = findViewById(R.id.btNhan);
        buttonChia = findViewById(R.id.btChia);

    }


}