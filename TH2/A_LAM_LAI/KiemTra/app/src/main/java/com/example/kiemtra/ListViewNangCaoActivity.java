package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewNangCaoActivity extends AppCompatActivity {
    private MainActivity context;
    private int layout;
    private List<MyTodo> myTodo;

    public ListViewNangCaoActivity(MainActivity context, int layout, List<MyTodo> myTodo) {
        this.context = context;
        this.layout = layout;
        this.myTodo = myTodo;
    }


    public int getCount() {
        return myTodo.size();
    }


    public Object getItem(int position) {
        return myTodo.get(position);
    }
    public long getItemId(int position) {
        // If MyTodo has a unique identifier, return it here
        // Otherwise, you can return position
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View viewTodo = convertView;
        if (viewTodo == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            viewTodo = inflater.inflate(layout, parent, false);
        }
        //Bind dữ liệu phần tử vào View
        MyTodo todo = myTodo.get(position);
        TextView txtTenCV = viewTodo.findViewById(R.id.txtTenCV);
        TextView txtThoiGian = viewTodo.findViewById(R.id.txtThoigian);
        txtTenCV.setText(String.format("%s", todo.getTenCV()));
//        txtThoiGian.setText(String.format("%s", todo.getThoiGian()));

        return viewTodo;
    }
}