package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText editTextTemperature;
    RadioGroup radioGroupConversion;
    Button buttonConvert,buttonClear,buttonExit;
    TextView textViewResult;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperature = findViewById(R.id.editND);
        radioGroupConversion = findViewById(R.id.radioChon);
        buttonConvert = findViewById(R.id.btchuyen);
        textViewResult = findViewById(R.id.txtvKQ);
        buttonClear= findViewById(R.id.buttonClear);
        buttonExit = findViewById(R.id.buttonExit);
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CDNhietDo();
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaData();
            }
        });
          buttonExit.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  finish(); // Kết thúc ứng dụng
              }
          });
      }

    private void CDNhietDo() {
        double temperature = Double.parseDouble(editTextTemperature.getText().toString());
        int selectedId = radioGroupConversion.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);

        if (selectedId == R.id.radioButtonCtoF) {
            // Chuyển đổi từ Celsius sang Fahrenheit
            double result = (temperature * 9 / 5) + 32;
            textViewResult.setText("Kết quả: " + result + "°F");
        } else if (selectedId == R.id.radioButtonFtoC) {
            // Chuyển đổi từ Fahrenheit sang Celsius
            double result = (temperature - 32) * 5 / 9;
            textViewResult.setText("Kết quả: " + result + "°C");
        }
    }
    private void XoaData() {
        editTextTemperature.getText().clear();
        radioGroupConversion.clearCheck();
        textViewResult.setText("");
    }
}