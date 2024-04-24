package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    public static  int traVe_Activity2=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent a=getIntent();
        String dl= a.getStringExtra("dulieu");

        EditText et=findViewById(R.id.et);
        et.setText(dl);
        Button button=findViewById(R.id.btFinish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent();
                String s=et.getText().toString();
                b.putExtra("data",s);
                setResult(traVe_Activity2,b);
finish();
            }
        });
    }
}