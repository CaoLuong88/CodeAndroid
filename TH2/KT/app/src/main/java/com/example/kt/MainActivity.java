package com.example.kt;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     private EditText etName, etQuantity;
       private CheckBox cbVip;
        private TextView tvTotal,khachhang;
        private Button btnCalculate, btnStatistics,btnNext;
        private int total = 0;
    private int invoiceCount = 0;
    private int totalCustomers = 0;
    private int totalVipCustomers = 0;
    private int totalRevenue = 0;

    private int calculateTotal() {

        int quantity = Integer.parseInt(etQuantity.getText().toString());
        int price = 20000;

        if (cbVip.isChecked()) {
            total = (int) (quantity * price * 0.9);
        } else {
            total = quantity * price;
        }

        return total;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        khachhang =findViewById(R.id.tvTotalCustomers);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = calculateTotal();
                tvTotal.setText("Tổng tiền: " + total);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invoiceCount++;
                etName.setText("Khách hàng " + invoiceCount);
                etQuantity.setText("");
                cbVip.setChecked(false);
            }
        });

//        btnStatistics.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                totalCustomers++;
//                if (cbVip.isChecked()) {
//                    totalVipCustomers++;
//                }
//                totalRevenue += total;
//
//                tvTotalCustomers.setText("Tổng số khách hàng: " + totalCustomers);
//                tvTotalVipCustomers.setText("Tổng số khách hàng VIP: " + totalVipCustomers);
//                tvTotalRevenue.setText("Tổng doanh thu: " + totalRevenue);
//            }
//        });



    }




}