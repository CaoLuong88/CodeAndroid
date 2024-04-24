package com.example.bai7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btdongy;
    EditText emailId;
    ///check email
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText editphoneNumber;
    //check phone
    String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]" + "*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    Matcher m;
    EditText edngaysinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btdongy = findViewById(R.id.btDongY);
        emailId = findViewById(R.id.edEmail);
        editphoneNumber = findViewById(R.id.edDienThoai);
        edngaysinh = findViewById(R.id.edNgaySinh);

        btdongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // kiem tra email

                if (emailId.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "nhap email", Toast.LENGTH_LONG).show();
                } else {
                    if (emailId.getText().toString().matches(emailPattern) == false) {
                        Toast.makeText(getApplicationContext(), "Email khong dung", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "dia chi email dung", Toast.LENGTH_LONG).show();
                    }
                }

                // kiemtra sdt
                Pattern r = Pattern.compile(pattern);
                if (editphoneNumber.getText().toString().trim().equals("") == true) {
                    Toast.makeText(MainActivity.this, "nhap so dien thoai", Toast.LENGTH_LONG).show();
                } else {
                    m = r.matcher(editphoneNumber.getText().toString().trim());
                    if (m.find()) {
                        Toast.makeText(MainActivity.this, "sdt dung", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "sdt sai", Toast.LENGTH_LONG).show();
                    }
                }
                //dat focus
                if (emailId.getText().toString().isEmpty() ||
                        emailId.getText().toString().trim().matches(emailPattern) == false) {
                    emailId.requestFocus();
                } else if (editphoneNumber.getText().toString().trim().equals("") == true || m.find() == false) {
                    editphoneNumber.requestFocus();
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("thong bao");
                alertDialog.setMessage("Ban vua nhap");
                alertDialog.show();
            }
        });
    }
}