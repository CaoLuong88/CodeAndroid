package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button buttonAdd;
    private ListView listViewSubjects;
    private ArrayList<String> subjectsList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewSubjects = findViewById(R.id.listViewSubjects);
        subjectsList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjectsList);
        listViewSubjects.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddSubjectDialog();
            }
        });
    }
        private void showAddSubjectDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog_add_subject, null);
            builder.setView(dialogView);

            final EditText editTextSubjectName = dialogView.findViewById(R.id.editTextSubjectName);
            final EditText editTextRoom = dialogView.findViewById(R.id.editTextRoom);
            final EditText editTextDay = dialogView.findViewById(R.id.editTextDay);

            builder.setTitle("Thêm Môn Học Mới");
            builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String subjectName = editTextSubjectName.getText().toString();
                    String room = editTextRoom.getText().toString();
                    String day = editTextDay.getText().toString();

                    if (!subjectName.isEmpty() && !room.isEmpty() && !day.isEmpty()) {
                        String subjectInfo = subjectName + " - " + room + " - " + day;
                        subjectsList.add(subjectInfo);
                        adapter.notifyDataSetChanged();
                    }
                }
            });
            builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
}