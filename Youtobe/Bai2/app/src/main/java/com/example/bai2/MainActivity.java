package com.example.bai2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
//        textView.setText("thay doi text");
//        String s =textView.getText().toString();
        Button button=findViewById(R.id.btEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(MainActivity.this,MainActivity2.class);
                String s=tv.getText().toString();
                i.putExtra("dulieu",s);
//                startActivity(i);
                startActivityForResult(i,MainActivity2.traVe_Activity2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== MainActivity2.traVe_Activity2){
            String s=data.getStringExtra("data");
            tv.setText(s);
        }
    }
}