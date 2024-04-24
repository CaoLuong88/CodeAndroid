package com.example.kiemtra;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class PhepTinh extends AppCompatActivity {

    EditText editText1, editText2;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonExit;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pheptinh);
        editText1 = findViewById(R.id.editSoA);
        editText2 = findViewById(R.id.editSoB);
        textViewResult = findViewById(R.id.editKQ);

        buttonAdd = findViewById(R.id.btcong);
        buttonSubtract = findViewById(R.id.bttru);
        buttonMultiply = findViewById(R.id.btnhan);
        buttonDivide = findViewById(R.id.btchia);
        buttonExit = findViewById(R.id.btthoat);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('/');
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc chương trình
            }
        });
    }

    private void calculateResult(char operator) {
        double num1 = Double.parseDouble(editText1.getText().toString());
        double num2 = Double.parseDouble(editText2.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textViewResult.setText("Không thể chia cho 0");
                    return;
                }
                break;
        }

        textViewResult.setText(" " + result);

    }
}
