package com.example.sqlitedemo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText etName,etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etName=findViewById(R.id.et_Name_Update);
        etAge=findViewById(R.id.et_Age_Update);

    }
    public void btnAdd_Update_click(View view) {
        KhachHangModel khmodel;
        try {
            khmodel=new KhachHangModel(-1,etName.getText().toString(),Integer.parseInt(etAge.getText().toString()));
            Toast.makeText(UpdateActivity.this, khmodel.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(UpdateActivity.this, "Errorr", Toast.LENGTH_SHORT).show();
            khmodel=new KhachHangModel(-1,"error",0);
        }
        DatabaseHelper  databaseHelper= new DatabaseHelper(UpdateActivity.this);
        Boolean success=databaseHelper.addOne(khmodel);
        if(success)
            Toast.makeText(UpdateActivity.this, "success", Toast.LENGTH_SHORT).show();
        else Toast.makeText(UpdateActivity.this, "failed", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(UpdateActivity.this,MainActivity.class);
        //String message = "";
        //intent.putExtra("Id", message);
        startActivity(intent);
    }
    public void btnBack_Update_click(View view) {
        Intent intent=new Intent(UpdateActivity.this,MainActivity.class);
        //String message = "";
        //intent.putExtra("Id", message);
        startActivity(intent);
    }

}