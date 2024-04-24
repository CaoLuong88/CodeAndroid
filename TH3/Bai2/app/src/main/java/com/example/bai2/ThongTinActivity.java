package com.example.bai2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class ThongTinActivity extends AppCompatActivity {
    EditText edhoten,edngaysinh,edmasinhvien;
    RadioGroup rggioitinh;
    CheckBox cbtienganh,cbtiengnhat;
    Switch swsinhvien;
    Spinner spchonkhoa;
    LinearLayout llhienmasinhvien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);

        edhoten=findViewById(R.id.et_HoTen);
        edngaysinh=findViewById(R.id.et_NgaySinh);
        edmasinhvien=findViewById(R.id.et_student_code);
        rggioitinh=findViewById(R.id.rgGioiTinh);
        cbtienganh=findViewById(R.id.cbTiengAnh);
        cbtiengnhat=findViewById(R.id.cbTiengNhat);
        swsinhvien=findViewById(R.id.swSinhVien);
        spchonkhoa=findViewById(R.id.spKhoa);
        llhienmasinhvien=findViewById(R.id.ll_student);

        String[] dulieukhoa= {"KINH TE","CNTT&TT"};
        AlertDialog.Builder=new Build();
    }
}