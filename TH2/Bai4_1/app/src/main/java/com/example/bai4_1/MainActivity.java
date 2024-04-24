package com.example.bai4_1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextDisplay;
    String currentInput = "";
    Double operand1 = null;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDisplay = findViewById(R.id.editTextDisplay);
    }

    public void onNumberClick(View view) {
        String value = ((View) view).getTag().toString();
        currentInput += value;
        editTextDisplay.setText(currentInput);
    }

    public void onOperatorClick(View view) {
        if (!currentInput.isEmpty()) {
            operand1 = Double.parseDouble(currentInput);
            operator = ((View) view).getTag().toString();
            currentInput = "";
        }
    }

    public void onDecimalClick(View view) {
        if (!currentInput.contains(".")) {
            currentInput += ".";
            editTextDisplay.setText(currentInput);
        }
    }

    public void onEqualsClick(View view) {
        if (!currentInput.isEmpty() && operand1 != null && !operator.isEmpty()) {
            double operand2 = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        editTextDisplay.setText("Error: Cannot divide by zero");
                        return;
                    }
                    break;
            }

            editTextDisplay.setText(String.valueOf(result));
            operand1 = null;
            currentInput = String.valueOf(result);
        }
    }

    public void onDeleteClick(View view) {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            editTextDisplay.setText(currentInput);
        }
    }
}
