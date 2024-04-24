package com.example.bai10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvmonhoc;
    ArrayList arrayName;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvmonhoc=findViewById(R.id.lvmonhoc);
        arrayName=new ArrayList<>();
        arrayName.add("lap trinh");
        arrayName.add("lap trinh truc quan");
        arrayName.add("lap ");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayName);
        lvmonhoc.setAdapter(adapter);
        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentVieư, View v, int i, long l) {
                ShowDialogDelete(i);
                return;
            }
        });
    }
    private void ShowDialogDelete(int position){
        AlertDialog.Builder alerDialog=new AlertDialog.Builder(this);
        alerDialog.setTitle("Thong bao");
        alerDialog.setIcon(R.mipmap.ic_launcher);
        alerDialog.setMessage("ban chac chan muon xoa");
        alerDialog.setNegativeButton("Huy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        alerDialog.setPositiveButton("dong y", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayName.remove(position);
                adapter.notifyAll();
                Toast.makeText(MainActivity.this, "Xóa môn học thành công!", Toast.LENGTH_SHORT).show();
            }
        });
        alerDialog.show();
    }
}