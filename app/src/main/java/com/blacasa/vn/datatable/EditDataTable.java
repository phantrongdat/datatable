package com.blacasa.vn.datatable;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EditDataTable extends TableLayout {
    private List<String> mColumns;
    private List<List<String>> mDataList;
    private List<List<EditText>> mContentList;

    public EditDataTable(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditDataTable(Context context) {
        super(context);
        init();
    }

    private void init() {
        mDataList = new ArrayList<>();
        mContentList = new ArrayList<>();
    }

    public void setHeader(List<String> columns) {
        if (columns != null) {
            mColumns = columns;
            TableRow row = new TableRow(getContext());
            for (String column : columns) {
                TextView tv = new TextView(getContext());
                tv.setWidth(getResources().getDimensionPixelSize(R.dimen.cell_width));
                tv.setText(column);
                tv.setBackgroundResource(R.drawable.cell_border_gray);
                row.addView(tv);
            }
            addView(row);
            mDataList.add(columns);
        }
    }

    public void setContents(List<List<String>> rows) {
        for (List<String> row : rows) {
            addRow(row);
        }
    }

    private void addRow(List<String> rowDataList) {
        if (rowDataList != null) {
            TableRow row = new TableRow(getContext());
            List<EditText> editTexts = new ArrayList<>();
            for (String content : rowDataList) {
                EditText edt = new EditText(getContext());
                edt.setWidth(getResources().getDimensionPixelSize(R.dimen.cell_width));
                edt.setText(content);
                edt.setBackgroundResource(R.drawable.cell_border_gray);
                editTexts.add(edt);
                row.addView(edt);
            }
            addView(row);
            mDataList.add(rowDataList);
            mContentList.add(editTexts);
        }
    }

    public List<List<String>> getDataList() {
        List<List<String>> list = new ArrayList<>();
        for (List<EditText> editTexts : mContentList) {
            List<String> data = new ArrayList<>();

            for (EditText editText : editTexts) {
                if (editText != null) {
                    data.add(editText.getText().toString());
                }
            }
            list.add(data);
        }
        return list;
    }

    public void clearAll() {
        removeAllViews();
        mContentList.clear();
        mDataList.clear();
    }

    public void clearContent() {
        removeAllViews();
        mContentList.clear();
        mDataList.clear();
        setHeader(mColumns);
        addEmptyRow(mColumns.size());
    }

    public void addEmptyRow(int columns) {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            row.add("");
        }
        addRow(row);
    }
}