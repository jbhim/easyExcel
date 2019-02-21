package com.amcjt.a003;

import org.apache.poi.ss.usermodel.CellStyle;

public interface IExecl {
    void createExecl();

    void createSheet();

    void createSheet(String... SheetNames);

    void createRow();

    void createRow(int rowSize);

    void createCell();

    void createCell(int cellSize);

    void setDropDownList(int firstRow, int lastRow, int firstCol, int lastCol, String[] dataList);

    void setWholeStyle(CellStyle style);
}
