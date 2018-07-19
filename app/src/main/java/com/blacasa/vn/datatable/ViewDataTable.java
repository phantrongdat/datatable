package com.blacasa.vn.datatable;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewDataTable extends TableLayout {
    private List<String> mColumns;

    public ViewDataTable(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewDataTable(Context context) {
        super(context);
        init();
    }

    private void init() {
    }

    public void setHeader(List<String> columns) {
        if (columns != null) {
            mColumns = columns;
            addRow(columns);
        }
    }

    public void setContents(List<List<String>> rows) {
        for (List<String> row : rows) {
            addRow(row);
        }
    }

    public void addRow(List<String> rowDataList) {
        if (rowDataList != null) {
            TableRow row = new TableRow(getContext());
            for (String data : rowDataList) {
                TextView tv = new TextView(getContext());
                tv.setWidth(getResources().getDimensionPixelSize(R.dimen.cell_width));
                tv.setText(data);
                tv.setTextColor(Color.GRAY);
                tv.setBackgroundResource(R.drawable.cell_border_gray);
                row.addView(tv);
            }
            addView(row);
        }
    }

    public void clearAll() {
        removeAllViews();
    }

    public void clearContent() {
        removeAllViews();
        addRow(mColumns);
    }

}