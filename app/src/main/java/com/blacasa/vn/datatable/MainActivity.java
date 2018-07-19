package com.blacasa.vn.datatable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditDataTable edtDataTable;
    private ViewDataTable tvDataTable;
    private List<String> columns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtDataTable = findViewById(R.id.edt_data_table);
        tvDataTable = findViewById(R.id.tv_data_table);
        columns = new ArrayList<>();
        columns.add("A");
        columns.add("B");
        columns.add("C");
        columns.add("D");
        columns.add("E");
        edtDataTable.setHeader(columns);
        edtDataTable.addEmptyRow(columns.size());
    }

    public void addRow(View view) {
        if (edtDataTable.getVisibility() != View.GONE){
            edtDataTable.addEmptyRow(columns.size());
        } else {
            reset(view);
        }
    }

    public void submit(View view) {
        List<List<String>> tableDataList = edtDataTable.getDataList();
        edtDataTable.setVisibility(View.GONE);
        tvDataTable.setVisibility(View.VISIBLE);
        tvDataTable.setHeader(columns);
        tvDataTable.setContents(tableDataList);
    }

    public void reset(View view) {
        edtDataTable.setVisibility(View.VISIBLE);
        edtDataTable.clearContent();
        tvDataTable.setVisibility(View.GONE);
        tvDataTable.clearAll();
    }
}
