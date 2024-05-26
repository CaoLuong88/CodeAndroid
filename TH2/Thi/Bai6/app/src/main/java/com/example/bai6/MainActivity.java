package com.example.bai6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextA, editTextB;
    private Button buttonSolve;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        buttonSolve = findViewById(R.id.buttonSolve);
        textViewResult = findViewById(R.id.textViewResult);

        buttonSolve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String strA = editTextA.getText().toString().trim();
                String strB = editTextB.getText().toString().trim();
                if (strA.isEmpty() || strB.isEmpty()) {
                    textViewResult.setText("Vui lòng nhập giá trị a và b");
                    return;
                }
                double a = Double.parseDouble(strA);
                double b = Double.parseDouble(strB);
                if (a == 0) {
                    if (b == 0) {
                        textViewResult.setText("Phương trình có vô số nghiệm");
                    } else {
                        textViewResult.setText("Phương trình vô nghiệm");
                    }
                } else {
                    double x = -b / a;
                    textViewResult.setText("Nghiệm của phương trình là x = " + x);
                }
            }
        });
    }
    }
