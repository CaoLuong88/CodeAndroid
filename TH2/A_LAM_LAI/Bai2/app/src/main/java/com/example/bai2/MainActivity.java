package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText soa,sob,ketqua;
    Button cong,tru,nhan,chia,thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soa=findViewById(R.id.editSoA);
        sob=findViewById(R.id.editSoB);
        ketqua=findViewById(R.id.editKQ);
        cong=findViewById(R.id.btcong);
        tru=findViewById(R.id.bttru);
        nhan=findViewById(R.id.btnhan);
        chia=findViewById(R.id.btchia);
        thoat=findViewById(R.id.btthoat);

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh('+');
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh('-');
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh('*');
            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh('/');
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void pheptinh(char operator){
    double so1=Double.parseDouble(soa.getText().toString());
    double so2=Double.parseDouble(sob.getText().toString());
    double kq=0;
    switch (operator){
        case '+':
            kq=so1+so2;
            break;
        case '-':
            kq=so1-so2;
            break;
        case '*':
            kq=so1*so2;
            break;
        case '/':
            if (so2!=0) {
                kq = so1 / so2;
            }else {
                ketqua.setText("0 the chia 0");
                return;
            }
            break;
    }
    ketqua.setText(" "+kq);
    }
}