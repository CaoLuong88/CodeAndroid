package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhepTinhActivity extends AppCompatActivity {
    EditText edsoa,edsob;
    Button btCong,btTru,btNhan,btChia,btThoat;
    TextView txtketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phep_tinh);

        edsoa=findViewById(R.id.editSoA);
        edsob=findViewById(R.id.editSoB);
        txtketqua=findViewById(R.id.editKQ);
        btCong=findViewById(R.id.btcong);
        btTru=findViewById(R.id.bttru);
        btNhan=findViewById(R.id.btnhan);
        btChia=findViewById(R.id.btchia);
        btThoat=findViewById(R.id.btthoat);

        btCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hamtinh('+');
            }
        });
        btTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hamtinh('-');
            }
        });
        btNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hamtinh('*');
            }
        });
        btChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hamtinh('/');
            }
        });
        btThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void hamtinh(char tinh){
        double soa=Double.parseDouble(edsoa.getText().toString());
        double sob=Double.parseDouble(edsob.getText().toString());
        double kq=0;
        switch (tinh){
            case '+':
                kq=soa+sob;
                break;
            case '-': kq=soa-sob;break;
            case '*': kq=soa *sob;break;
            case '/':
                if (sob!=0){
                kq=soa/sob;}
                else {
                    txtketqua.setText("khong chia cho 0");
                    return;
                }
            break;
        }
        txtketqua.setText(""+kq);
    }
}