package com.example.bai3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
public class MonHocAdapter extends ArrayAdapter<MonHoc> {
    private Context context;
    private List<MonHoc> monHocList;
    public MonHocAdapter( Context context, List<MonHoc> objects) {
        super(context, 0, objects);
        this.context = context;
        this.monHocList = objects;
    }

    public View getView(final int position,  View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.mon_hoc_item, parent, false);
        }
        TextView tvTenMonHoc = convertView.findViewById(R.id.tvTenMonHoc);
        Button btnSua = convertView.findViewById(R.id.btnSua);
        Button btnXoa = convertView.findViewById(R.id.btnXoa);

        final MonHoc monHoc = monHocList.get(position);

        tvTenMonHoc.setText(monHoc.getTen());
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog(monHoc, position);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteDialog(monHoc, position);
            }
        });

        return convertView;
    }

    private void showEditDialog(final MonHoc monHoc, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Sửa Môn Học");

        View viewInflated = LayoutInflater.from(context).inflate(R.layout.dialog_edit_monhoc, null);
        builder.setView(viewInflated);

        final EditText inputTen = viewInflated.findViewById(R.id.inputTen);
        final EditText inputMa = viewInflated.findViewById(R.id.inputMa);

        inputTen.setText(monHoc.getTen());
        inputMa.setText(monHoc.getMa());

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String tenMoi = inputTen.getText().toString();
                String maMoi = inputMa.getText().toString();
                monHoc.setTen(tenMoi);
                monHoc.setMa(maMoi);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    private void showDeleteDialog(final MonHoc monHoc, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xóa Môn Học");
        builder.setMessage("Bạn có chắc chắn muốn xóa môn học này không?");

        builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                monHocList.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
