package com.jiangnanyidianyu.BaseDemo.POI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName POI
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/2/24 9:31
 */
public class POI {

    @Test
    public void POI_07() throws IOException {
        //创建工作蒲
        Workbook workbook = new XSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("xxx统计表");
        //创建行
        Row sheetRow1 = sheet.createRow(0);
        Cell cell11 = sheetRow1.createCell(0);
        cell11.setCellValue("测试总数");
        Cell cell12 = sheetRow1.createCell(1);
        cell12.setCellValue("测试日期");

        Row sheetRow2 = sheet.createRow(1);
        Cell cell21 = sheetRow2.createCell(0);
        cell21.setCellValue(76328);

        Cell cell22 = sheetRow2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\测试.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        System.out.println("测试表导出成功！");
    }
}
