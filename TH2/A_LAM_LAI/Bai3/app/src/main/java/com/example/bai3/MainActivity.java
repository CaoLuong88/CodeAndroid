package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ednhietdo;
    RadioGroup rdgrnhietdo;
    Button btchuyendoi,btreset,btthoat;
    TextView txtketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ednhietdo=findViewById(R.id.editND);
        rdgrnhietdo=findViewById(R.id.radioChon);
        txtketqua=findViewById(R.id.txtvKQ);
        btchuyendoi=findViewById(R.id.btchuyen);
        btreset=findViewById(R.id.buttonClear);
        btthoat=findViewById(R.id.buttonExit);

        btchuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoiNhienDo();
            }
        });
        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void DoiNhienDo(){
        double nhapnhietdo=Double.parseDouble(ednhietdo.getText().toString());
        int chonrdgr=rdgrnhietdo.getCheckedRadioButtonId();
        RadioButton thaydoirdgr=findViewById(chonrdgr);
        if(chonrdgr==R.id.radioButtonCtoF){
            double ketqua=(nhapnhietdo * 9/5)+32;
            txtketqua.setText("ket qua: "+ketqua+"F");
        }else if (chonrdgr==R.id.radioButtonFtoC) {
        double ketqua=(nhapnhietdo-32)*5/9;
        txtketqua.setText("ket qua :"+ketqua+" C");
        }
    }
    private void reset(){
        ednhietdo.getText().clear();
        rdgrnhietdo.clearCheck();
        txtketqua.setText(" ");
    }
}