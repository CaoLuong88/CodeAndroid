package com.example.sqlitedemo3;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class KhachHangAdapter extends BaseAdapter  {
    private Context mContext;
    private ArrayList<KhachHangModel> khachHangModelList;
    public KhachHangAdapter (Context mContext, ArrayList<KhachHangModel> khachHangModelList)
    {
        this.mContext=mContext;
        this.khachHangModelList=khachHangModelList;
    }
    @Override
    public int getCount() {
        return khachHangModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return khachHangModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;//khachHangModelList.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v=View.inflate(mContext,R.layout.detail_list,null);
        TextView txtname= (TextView) v.findViewById(R.id.txtname);
        TextView txtage=(TextView) v.findViewById(R.id.txtage);
        txtname.setText(khachHangModelList.get(position).getName());
        txtage.setText(String.valueOf(khachHangModelList.get(position).getAge()));
        v.setTag(khachHangModelList.get(position).getId());
        return v;
    }

}
