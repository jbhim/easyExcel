package com.amcjt.a002;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CreateExcel {
    private Workbook workbook;
    private List<Sheet> sheets;

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public List<Sheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<Sheet> sheets) {
        this.sheets = sheets;
    }

    CreateExcel() {
        workbook = new HSSFWorkbook();
    }

    public CreateExcel createSheet(String... array) {
        sheets = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Sheet sheet = workbook.createSheet(array[i]);
            sheets.add(sheet);
        }
        return this;
    }

    public void addSheet(Sheet sheet) {
        sheets.add(sheet);
    }

    public Sheet getSheet(int index) {
        return sheets.get(index);
    }

    public void createCell(Sheet sheet, List<String> data) {
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        // 普通写入操作
        cell.setCellValue("请选择");// 这是实验
        // 生成下拉列表
        // 只对(0，0)单元格有效
        CellRangeAddressList regions = new CellRangeAddressList(0, 10, 0, 0);
        // 生成下拉框内容
        DVConstraint constraint = DVConstraint.createExplicitListConstraint(new String[]{"1", "2", "3"});
        // 绑定下拉框和作用区域
        HSSFDataValidation data_validation = new HSSFDataValidation(regions, constraint);
        // 对sheet页生效
        sheet.addValidationData(data_validation);
        // 写入文件
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("c:/Users/ywkj/Desktop/cworkbook.xls");
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 结束
        System.out.println("Over");
    }

    public static void main(String[] args) {
        List<String> boxData = new ArrayList<>();
        boxData.add("");
        CreateExcel excel = new CreateExcel()
                .createSheet("sheet1");
        excel.createCell(excel.getSheet(0), boxData);
    }
}
