package com.example.kiemtra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
    Button thoat,hienthi;
    EditText hoten,ngaysinh,StudentCode;
    Spinner spinnerKhoa;
    RadioGroup rggioitinh;
    Switch sinhvien;
    CheckBox cbEnglish,cbJapanese;
    LinearLayout llStudentCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);

        hienthi=findViewById(R.id.bt_HienThi);
        thoat=findViewById(R.id.btThoatThongTin);
        hoten=findViewById(R.id.et_HoTen);
        ngaysinh=findViewById(R.id.et_NgaySinh);
        spinnerKhoa=findViewById(R.id.spKhoa);
        rggioitinh=findViewById(R.id.rgGioiTinh);
        sinhvien=findViewById(R.id.swSinhVien);
        cbEnglish=findViewById(R.id.cbTiengAnh);
        cbJapanese=findViewById(R.id.cbTiengNhat);
        llStudentCode = findViewById(R.id.ll_student);
        StudentCode = findViewById(R.id.et_student_code);
        String[] dulieukhoa={"CNTT&TT","NHOAI NGU","KINH TE"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dulieukhoa);
        spinnerKhoa.setAdapter(adapter);

        sinhvien.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    llStudentCode.setVisibility(View.VISIBLE);
                } else {
                    llStudentCode.setVisibility(View.GONE);
                }
            }
        });
        hienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=hoten.getText().toString();
                String birthday=ngaysinh.getText().toString();
                String masv=StudentCode.getText().toString();
                String chonkhoa=spinnerKhoa.getSelectedItem().toString();
                int chonrdbid=rggioitinh.getCheckedRadioButtonId();
                RadioButton chonrdb=findViewById(chonrdbid);
                String gioitinh=chonrdb.getText().toString();

                StringBuilder sbLanguages = new StringBuilder();
                // Lấy dữ liệu từ checkbox
                if (cbEnglish.isChecked()) {
                    sbLanguages.append("Tiếng Anh").append("\n");
                }
                if (cbJapanese.isChecked()) {
                    sbLanguages.append("Tiếng Nhật").append("\n");
                }
                Switch sw = findViewById(R.id.swSinhVien);
                boolean isOn = sw.isChecked();

                AlertDialog.Builder builder=new AlertDialog.Builder(ThongTinActivity.this);
                builder.setTitle("Hiển thị thông tin");
                builder.setMessage("Họ tên: "+name+"\nNgày sinh: "+birthday+"\nGiới tính: "+gioitinh+"\n Môn học: "+sbLanguages.toString()+(isOn ? "Là sinh viên" : "Không là sinh viên")+"\n Mã sinh viên: "+masv+"\nKhoa: "+chonkhoa+"\n");
                builder.setPositiveButton("Dong",null);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}