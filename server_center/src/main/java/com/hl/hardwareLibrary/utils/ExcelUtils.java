package com.hl.hardwareLibrary.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.primitives.Doubles;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    /**
     * 导出表格
     * @param sheetNum sheet的位置，0表示表格中的第一个sheet
     * @param sheetTitle sheet 的名称
     * @param headers   表格的头（第一行）
     * @param columns   表格数据对应列字段
     * @param list  表格数据
     * @param out   输出流
     * @throws Exception
     */
    public static void ExportExcel(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, String[] columns, List<Map> list, OutputStream out) throws Exception{
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum,sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);

        //style.setFillBackgroundColor(HSSFColor.WHITE.index);
        //style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        //font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if(list!=null&&list.size()>0){
            int index=1;
            for(Map map:list){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<columns.length;i++){
                    Cell cell=row.createCell(i);
                    String filedName=columns[i];

                    Object value = map.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }
    }



    public static <T> void ExportExcelList(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, String[] columns, List<T> list, OutputStream out) throws Exception{
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum,sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);

        //style.setFillBackgroundColor(HSSFColor.WHITE.index);
        //style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        //font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if(list!=null&&list.size()>0){
            int index=1;
            for(T t:list){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<columns.length;i++){
                    Cell cell=row.createCell(i);
                    String filedName=columns[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }
    }



    public static <T> void ExportExcelList(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, String[] columns, List<T> list, OutputStream out,String row1) throws Exception{
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum,sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);

        //style.setFillBackgroundColor(HSSFColor.WHITE.index);
        //style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        //font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        int row00 = 0;
        if(StringUtils.isNotEmpty(row1)){


            HSSFRow row = sheet.createRow(row00);
            HSSFCell cell = row.createCell(0);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(row1);
            cell.setCellValue(text.toString());


            sheet.addMergedRegion(new CellRangeAddress(row00,row00,0,headers.length));
            row00 = row00+1;
        }


        HSSFRow row = sheet.createRow(row00);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }

        row00 = row00+1;
        //遍历集合数据，产生数据行
        if(list!=null&&list.size()>0){
            int index=row00++;
            for(T t:list){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<columns.length;i++){
                    Cell cell=row.createCell(i);
                    String filedName=columns[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }
    }


    public static <T> void ExportExcelGdsdf(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, String headers1,String[] headers2,String[] columns, List<T> list, OutputStream out) throws Exception{
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0,sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 10);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        int rowNum = 0;
        HSSFRow row0 = sheet.createRow(rowNum++);
        HSSFCell c00 = row0.createCell(0);
        c00.setCellValue(headers1);
        c00.setCellStyle(style);
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,22));

        //第二行
        HSSFRow row2 = sheet.createRow(rowNum++);
        HSSFCell cell1 = row2.createCell(0);
        cell1.setCellValue(headers2[0]);
        cell1.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));

        HSSFCell cell2 = row2.createCell(2);
        cell2.setCellValue(headers2[1]);
        cell2.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(1,2,2,2));

        HSSFCell cell3 = row2.createCell(3);
        cell3.setCellValue(headers2[2]);
        cell3.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(1,1,3,4));

        HSSFCell cell4 = row2.createCell(5);
        cell4.setCellValue(headers2[3]);
        cell4.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(1,1,5,10));

        HSSFCell cell5 = row2.createCell(11);
        cell5.setCellValue(headers2[4]);
        cell5.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(1,1,11,16));

        HSSFCell cell6 = row2.createCell(17);
        cell6.setCellValue(headers2[5]);
        cell6.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(1,1,17,22));

        HSSFRow row1 = sheet.createRow(rowNum++);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row1.createCell((short) i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if(list!=null&&list.size()>0){
            int index=3;
            for(T t:list){
                HSSFRow row4=sheet.createRow(index);
                index++;
                for(short i=0;i<columns.length;i++){
                    Cell cell=row4.createCell(i);
                    String filedName=columns[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);

                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }
    }




    public static <T> void ExportExcelGdsIndex(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] line1s, String headers1s, String[] headers2s, String[] strings, String[] columns1, List<T> list, String[] headers5s,JSONArray jsonArray,String[] headers6s,OutputStream out) throws Exception{
        //生成一个表格
        HSSFSheet sheet2 = workbook.createSheet();
        workbook.setSheetName(1,sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet2.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        int rowNum = 0;
        HSSFRow row0 = sheet2.createRow(rowNum++);
        HSSFCell c00 = row0.createCell(0);
        c00.setCellValue(headers1s);
        c00.setCellStyle(style);
        //合并单元格
        sheet2.addMergedRegion(new CellRangeAddress(0,0,0,29));

        //第二行
        HSSFRow row2 = sheet2.createRow(rowNum++);
        HSSFCell cell1 = row2.createCell(0);
        cell1.setCellValue(headers2s[0]);
        cell1.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(1,2,0,0));

        HSSFCell cell2 = row2.createCell(1);
        cell2.setCellValue(headers2s[1]);
        cell2.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(1,2,1,1));

        HSSFCell cell3 = row2.createCell(2);
        cell3.setCellValue(headers2s[2]);
        cell3.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(1,2,2,2));

        HSSFCell cell4 = row2.createCell(3);
        cell4.setCellValue(headers2s[3]);
        cell4.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(1,1,3,5));

        int a = 6;
        for (int i = 4;i<headers2s.length;i++){
            HSSFCell cell = row2.createCell(a);
            cell.setCellValue(headers2s[i]);
            cell.setCellStyle(style);
            sheet2.addMergedRegion(new CellRangeAddress(1,1,a,a+2));
            a = a+3;
        }

        /*HSSFCell cell4 = row2.createCell(3);
        cell4.setCellValue(headers2s[3]);
        cell4.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,3,5));

        HSSFCell cell5 = row2.createCell(6);
        cell5.setCellValue(headers2s[4]);
        cell5.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,6,8));

        HSSFCell cell6 = row2.createCell(9);
        cell6.setCellValue(headers2s[5]);
        cell6.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,9,11));

        HSSFCell cell7 = row2.createCell(12);
        cell7.setCellValue(headers2s[6]);
        cell7.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,12,14));

        HSSFCell cell8 = row2.createCell(15);
        cell8.setCellValue(headers2s[7]);
        cell8.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,15,17));

        HSSFCell cell9 = row2.createCell(18);
        cell9.setCellValue(headers2s[8]);
        cell9.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,18,20));

        HSSFCell cell10 = row2.createCell(21);
        cell10.setCellValue(headers2s[9]);
        cell10.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,21,23));

        HSSFCell cell11 = row2.createCell(24);
        cell11.setCellValue(headers2s[10]);
        cell11.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,24,26));

        HSSFCell cell12 = row2.createCell(27);
        cell12.setCellValue(headers2s[11]);
        cell12.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,27,29));*/

        HSSFRow row1 = sheet2.createRow(rowNum++);
        for (int i = 0; i < line1s.length; i++) {
            HSSFCell cell = row1.createCell((short) i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(line1s[i]);
            cell.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if(list!=null&&list.size()>0){
            int index=3;
            for(T t:list){
                HSSFRow row4=sheet2.createRow(index);
                index++;
                for(short i=0;i<columns1.length;i++){
                    Cell cell=row4.createCell(i);
                    String filedName=columns1[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);

                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }

        HSSFRow row10 = sheet2.createRow(3+list.size());

        HSSFCell cell10 = row10.createCell(1);
        cell10.setCellValue(headers5s[0]);
        cell10.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(3+list.size(),3+list.size(),1,2));

        HSSFCell cell11 = row10.createCell(3);
        cell11.setCellValue(headers5s[1]);
        cell11.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(3+list.size(),3+list.size(),3,5));

        int b = 6;
        for (int i = 0;i<jsonArray.size();i++){
            HSSFCell cell = row10.createCell(b);
            JSONObject o = (JSONObject) jsonArray.get(i);
            if ("1".equals(o.get("count"))){
                cell.setCellValue(o.get("sc02Txt")+"-"+o.get("sc04Txt"));
            }else {
                cell.setCellValue(o.get("sc02Txt")+"-"+o.get("sc04Txt")+"等"+o.get("count")+"个供电所");
            }
            //cell.setCellValue(headers2s[i]);
            cell.setCellStyle(style);
            sheet2.addMergedRegion(new CellRangeAddress(3+list.size(),3+list.size(),b,b+2));
            b = b+3;

        }


        //最后一栏数据
        HSSFRow row11 = sheet2.createRow(4+list.size());

        HSSFCell cell15 = row11.createCell(1);
        cell15.setCellValue(headers6s[0]);
        cell15.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(4+list.size(),4+list.size(),1,2));

        HSSFCell cell12 = row11.createCell(3);
        cell12.setCellValue(headers6s[1]);
        cell12.setCellStyle(style);
        sheet2.addMergedRegion(new CellRangeAddress(4+list.size(),4+list.size(),3,5));

        int c = 6;
        for (int i = 0;i<jsonArray.size();i++){
            HSSFCell cell13 = row11.createCell(c);
            JSONObject o = (JSONObject) jsonArray.get(i);
            cell13.setCellValue(o.get("indexValue").toString());
            //cell.setCellValue(headers2s[i]);
            cell13.setCellStyle(style);
            sheet2.addMergedRegion(new CellRangeAddress(4+list.size(),4+list.size(),c,c+2));
            c = c+3;

        }

        /*int size = list.size();
        HSSFRow row = sheet1.createRow(3 + size);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(headers2s[0]);
        cell.setCellStyle(style);
        sheet1.addMergedRegion(new CellRangeAddress(1,2,0,0));*/


    }

    public static <T> void ExportExcelAccountManager(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String head1s, String[] head2s, String[] line2, String[] columns1, List<T> list,OutputStream out) throws Exception {
        //生成一个表格
        HSSFSheet sheet3 = workbook.createSheet();
        workbook.setSheetName(2, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet3.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        int rowNum = 0;
        HSSFRow row0 = sheet3.createRow(rowNum++);
        HSSFCell c00 = row0.createCell(0);
        c00.setCellValue(head1s);
        c00.setCellStyle(style);
        //合并单元格
        sheet3.addMergedRegion(new CellRangeAddress(0, 0, 0, 10+(head2s.length-9)*3));

        //第二行
        HSSFRow row2 = sheet3.createRow(rowNum++);
        HSSFCell cell1 = row2.createCell(0);
        cell1.setCellValue(head2s[0]);
        cell1.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));

        HSSFCell cell2 = row2.createCell(1);
        cell2.setCellValue(head2s[1]);
        cell2.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));

        HSSFCell cell3 = row2.createCell(2);
        cell3.setCellValue(head2s[2]);
        cell3.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 2, 2, 2));

        HSSFCell cell4 = row2.createCell(3);
        cell4.setCellValue(head2s[3]);
        cell4.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 2, 3, 3));

        HSSFCell cell5 = row2.createCell(4);
        cell5.setCellValue(head2s[4]);
        cell5.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 2, 4, 4));

        HSSFCell cell6 = row2.createCell(5);
        cell6.setCellValue(head2s[5]);
        cell6.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 2, 5, 5));

        HSSFCell cell7 = row2.createCell(6);
        cell7.setCellValue(head2s[6]);
        cell7.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 2, 6, 6));

        HSSFCell cell8 = row2.createCell(7);
        cell8.setCellValue(head2s[7]);
        cell8.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));

        HSSFCell cell9 = row2.createCell(8);
        cell9.setCellValue(head2s[8]);
        cell9.setCellStyle(style);
        sheet3.addMergedRegion(new CellRangeAddress(1, 1, 8, 10));

        int a = 11;
        for (int i = 9; i < head2s.length; i++) {
            HSSFCell cell = row2.createCell(a);
            cell.setCellValue(head2s[i]);
            cell.setCellStyle(style);
            sheet3.addMergedRegion(new CellRangeAddress(1, 1, a, a + 2));
            a = a + 3;
        }

        HSSFRow row3 = sheet3.createRow(rowNum++);
        for (int i = 0; i < line2.length; i++) {
            HSSFCell cell = row3.createCell((short) i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(line2[i]);
            cell.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if (list != null && list.size() > 0) {
            int index = 3;
            for (T t : list) {
                HSSFRow row4 = sheet3.createRow(index);
                index++;
                for (short i = 0; i < columns1.length; i++) {
                    Cell cell = row4.createCell(i);
                    String filedName = columns1[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);

                    String textValue = value == null ? "" : value.toString();


                    if (textValue != null) {
                        Double d = Doubles.tryParse(textValue);
                        if (null != d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }

    }



    public static <T> void ExportExcelLookOut(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String head1s6, String[] head2s6, String[] line26, String[] columns16, List<T> list,OutputStream out) throws Exception {
        //生成一个表格
        HSSFSheet sheet5 = workbook.createSheet();
        workbook.setSheetName(0, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet5.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        int rowNum = 0;
        HSSFRow row0 = sheet5.createRow(rowNum++);
        HSSFCell c00 = row0.createCell(0);
        c00.setCellValue(head1s6);
        c00.setCellStyle(style);
        //合并单元格
        sheet5.addMergedRegion(new CellRangeAddress(0, 0, 0, 13+(head2s6.length-12)*3));

        //第二行
        HSSFRow row2 = sheet5.createRow(rowNum++);
        HSSFCell cell1 = row2.createCell(0);
        cell1.setCellValue(head2s6[0]);
        cell1.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));

        HSSFCell cell2 = row2.createCell(1);
        cell2.setCellValue(head2s6[1]);
        cell2.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));

        HSSFCell cell3 = row2.createCell(2);
        cell3.setCellValue(head2s6[2]);
        cell3.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 2, 2));

        HSSFCell cell4 = row2.createCell(3);
        cell4.setCellValue(head2s6[3]);
        cell4.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 3, 3));

        HSSFCell cell5 = row2.createCell(4);
        cell5.setCellValue(head2s6[4]);
        cell5.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 4, 4));

        HSSFCell cell6 = row2.createCell(5);
        cell6.setCellValue(head2s6[5]);
        cell6.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 5, 5));

        HSSFCell cell7 = row2.createCell(6);
        cell7.setCellValue(head2s6[6]);
        cell7.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 6, 6));

        HSSFCell cell8 = row2.createCell(7);
        cell8.setCellValue(head2s6[7]);
        cell8.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));

        HSSFCell cell9 = row2.createCell(8);
        cell9.setCellValue(head2s6[8]);
        cell9.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));

        HSSFCell cell10 = row2.createCell(9);
        cell10.setCellValue(head2s6[9]);
        cell10.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));

        HSSFCell cell11 = row2.createCell(10);
        cell11.setCellValue(head2s6[10]);
        cell11.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));

        HSSFCell cell12 = row2.createCell(11);
        cell12.setCellValue(head2s6[11]);
        cell12.setCellStyle(style);
        sheet5.addMergedRegion(new CellRangeAddress(1, 1, 11, 13));

        int a = 14;
        for (int i = 12; i < head2s6.length; i++) {
            HSSFCell cell = row2.createCell(a);
            cell.setCellValue(head2s6[i]);
            cell.setCellStyle(style);
            sheet5.addMergedRegion(new CellRangeAddress(1, 1, a, a + 2));
            a = a + 3;
        }

        HSSFRow row3 = sheet5.createRow(rowNum++);
        for (int i = 0; i < line26.length; i++) {
            HSSFCell cell = row3.createCell((short) i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(line26[i]);
            cell.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if (list != null && list.size() > 0) {
            int index = 3;
            for (T t : list) {
                HSSFRow row4 = sheet5.createRow(index);
                index++;
                for (short i = 0; i < columns16.length; i++) {
                    Cell cell = row4.createCell(i);
                    String filedName = columns16[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);

                    String textValue = value == null ? "" : value.toString();


                    if (textValue != null) {
                        Double d = Doubles.tryParse(textValue);
                        if (null != d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }

    }


    public static <T> void ExportExcelIndexSystem(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String head1s, String[] head2s, String[] columns, List<T> list,List<T> data4,List<T> data5,List<T> data6,OutputStream out) throws Exception {
        //生成一个表格
        HSSFSheet sheet4 = workbook.createSheet();
        workbook.setSheetName(3, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet4.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        int rowNum = 0;
        HSSFRow row0 = sheet4.createRow(rowNum++);
        HSSFCell c00 = row0.createCell(0);
        c00.setCellValue(head1s);
        c00.setCellStyle(style);
        //合并单元格
        sheet4.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));

        //第二行
        HSSFRow row1 = sheet4.createRow(rowNum++);
        for (int i = 0; i < head2s.length; i++) {
            HSSFCell cell = row1.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(head2s[i]);
            cell.setCellValue(text.toString());
        }


        //第二行
        /*HSSFRow row2 = sheet4.createRow(rowNum++);
        HSSFCell cell1 = row2.createCell(0);
        cell1.setCellValue("供电所");
        cell1.setCellStyle(style);*/

        //合并单元格
        sheet4.addMergedRegion(new CellRangeAddress(2, 1+data4.size(), 0, 0));
        sheet4.addMergedRegion(new CellRangeAddress(2+data4.size(), 1+data4.size()+data5.size(), 0, 0));
        sheet4.addMergedRegion(new CellRangeAddress(2+data4.size()+data5.size(), 1+data4.size()+data5.size()+data6.size(), 0, 0));


        //遍历集合数据，产生数据行
        if (list != null && list.size() > 0) {
            int index = 2;
            for (T t : list) {
                HSSFRow row3 = sheet4.createRow(index);
                index++;
                for (short i = 0; i < columns.length; i++) {
                    Cell cell = row3.createCell(i);
                    cell.setCellStyle(style);
                    String filedName = columns[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);

                    if ("SC04".equals(value)){
                        value = "供电所";
                    }
                    if ("SC05".equals(value)){
                        value = "客户经理";
                    }
                    if ("SC06".equals(value)){
                        value = "台区级";
                    }

                    String textValue = value == null ? "" : value.toString();


                    if (textValue != null) {
                        Double d = Doubles.tryParse(textValue);
                        if (null != d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }

    }



    //5级客户经理异常
    public static <T> void ExportSc05Exception(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] head1, String[] columns, List<T> list,String[] head2, String[] columns2, List<T> list2,String[] head5,String[] line5, String[] columns5, List<T> list5,String[] head6,String[] line6, String[] columns6, List<T> list6,OutputStream out) throws Exception {
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < head1.length; i++) {
            HSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(head1[i]);
            cell.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if(list!=null&&list.size()>0){
            int index=1;
            for(T t:list){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<columns.length;i++){
                    Cell cell=row.createCell(i);
                    String filedName=columns[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
            }

        HSSFRow row3 = sheet.createRow(8+list.size());
        for (int i = 0; i < head2.length; i++) {
            HSSFCell cell = row3.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(head2[i]);
            cell.setCellValue(text.toString());
        }

        if(list2!=null&&list2.size()>0){
            int index=9+list.size();
            for(T t:list2){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<columns2.length;i++){
                    Cell cell=row.createCell(i);
                    String filedName=columns2[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }

        HSSFRow row4 = sheet.createRow(14+list.size()+list2.size());
        HSSFCell cell1 = row4.createCell(0);
        cell1.setCellValue(line5[0]);
        cell1.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(14+list.size()+list2.size(), 15+list.size()+list2.size(), 0, 0));

        HSSFCell cell2 = row4.createCell(1);
        cell2.setCellValue(line5[1]);
        cell2.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(14+list.size()+list2.size(), 15+list.size()+list2.size(), 1, 1));

        HSSFCell cell3 = row4.createCell(2);
        cell3.setCellValue(line5[2]);
        cell3.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(14+list.size()+list2.size(), 15+list.size()+list2.size(), 2, 2));

        HSSFCell cell4 = row4.createCell(3);
        cell4.setCellValue(line5[3]);
        cell4.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(14+list.size()+list2.size(), 15+list.size()+list2.size(), 3, 3));

        HSSFCell cell5 = row4.createCell(4);
        cell5.setCellValue(line5[4]);
        cell5.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(14+list.size()+list2.size(), 15+list.size()+list2.size(),4, 4));

        HSSFCell cell6 = row4.createCell(5);
        cell6.setCellValue(line5[5]);
        cell6.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(14+list.size()+list2.size(), 15+list.size()+list2.size(), 5, 5));

        HSSFCell cell7 = row4.createCell(6);
        cell7.setCellValue(line5[6]);
        cell7.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(14+list.size()+list2.size(), 15+list.size()+list2.size(), 6, 6));

        HSSFCell cell8 = row4.createCell(7);
        cell8.setCellValue(line5[7]);
        cell8.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(14+list.size()+list2.size(), 15+list.size()+list2.size(), 7, 7));

        for (int i = 8; i < line5.length; i++) {
            HSSFCell cell = row4.createCell(i);
            cell.setCellValue(line5[i]);
            cell.setCellStyle(style);
        }
        HSSFRow row5 = sheet.createRow(15+list.size()+list2.size());
        for (int i = 0; i < head5.length; i++) {
            HSSFCell cell = row5.createCell((short) i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(head5[i]);
            cell.setCellValue(text.toString());
        }

        if(list5!=null&&list5.size()>0){
            int index=16+list.size()+list2.size();
            for(T t:list5){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<columns5.length;i++){
                    Cell cell=row.createCell(i);
                    String filedName=columns5[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }


        HSSFRow row6 = sheet.createRow(20+list.size()+list2.size()+list5.size());
        HSSFCell cell11 = row6.createCell(0);
        cell11.setCellValue(line6[0]);
        cell11.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 0, 0));

        HSSFCell cell21 = row6.createCell(1);
        cell21.setCellValue(line6[1]);
        cell21.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 1, 1));

        HSSFCell cell31 = row6.createCell(2);
        cell31.setCellValue(line6[2]);
        cell31.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 2, 2));

        HSSFCell cell41 = row6.createCell(3);
        cell41.setCellValue(line6[3]);
        cell41.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 3, 3));

        HSSFCell cell51 = row6.createCell(4);
        cell51.setCellValue(line6[4]);
        cell51.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(),4, 4));

        HSSFCell cell61 = row6.createCell(5);
        cell61.setCellValue(line6[5]);
        cell61.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(),5, 5));

        HSSFCell cell71 = row6.createCell(6);
        cell71.setCellValue(line6[6]);
        cell71.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 6, 6));

        HSSFCell cell81 = row6.createCell(7);
        cell81.setCellValue(line6[7]);
        cell81.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 7, 7));

        HSSFCell cell82 = row6.createCell(8);
        cell82.setCellValue(line6[8]);
        cell82.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 8, 8));

        HSSFCell cell83 = row6.createCell(9);
        cell83.setCellValue(line6[9]);
        cell83.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 9, 9));

        HSSFCell cell84 = row6.createCell(10);
        cell84.setCellValue(line6[10]);
        cell84.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 10, 10));

        HSSFCell cell85 = row6.createCell(11);
        cell85.setCellValue(line6[11]);
        cell85.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 11, 11));

        HSSFCell cell86 = row6.createCell(12);
        cell86.setCellValue(line6[12]);
        cell86.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(20+list.size()+list2.size()+list5.size(), 21+list.size()+list2.size()+list5.size(), 12, 12));

        for (int i = 13; i < line6.length; i++) {
            HSSFCell cell = row6.createCell(i);
            cell.setCellValue(line6[i]);
            cell.setCellStyle(style);
        }
        HSSFRow row7 = sheet.createRow(21+list.size()+list2.size()+list5.size());
        for (int i = 0; i < head6.length; i++) {
            HSSFCell cell = row7.createCell((short) i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(head6[i]);
            cell.setCellValue(text.toString());
        }

        if(list6!=null&&list6.size()>0){
            int index=22+list.size()+list2.size()+list5.size();
            for(T t:list6){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<columns6.length;i++){
                    Cell cell=row.createCell(i);
                    String filedName=columns6[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }

    }



    //一级指标导出
    public static <T> void ExportOneIndex(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String head1, String indexFomula,String[] head2,String[] line2,String[] line3,String[] column, List<T> list, OutputStream out) throws Exception{
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum,sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);

        //style.setFillBackgroundColor(HSSFColor.WHITE.index);
        //style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        //font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 10);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        int rowNum = 0;
        HSSFRow row = sheet.createRow(rowNum++);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(head1);
        cell.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,line3.length));

        HSSFRow row1 = sheet.createRow(rowNum++);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue(indexFomula);
        cell1.setCellStyle(style);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(1,1,0,line3.length));

        HSSFRow row3 = sheet.createRow(3);
        for (int i = 0; i < head2.length; i++) {
            HSSFCell cell3 = row3.createCell((short) i);
            cell3.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(head2[i]);
            cell3.setCellValue(text.toString());
        }

        HSSFRow row4 = sheet.createRow(4);
        for (int i = 0; i < line2.length; i++) {
            HSSFCell cell4 = row4.createCell((short) i);
            cell4.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(line2[i]);
            cell4.setCellValue(text.toString());
        }

        HSSFRow row5 = sheet.createRow(6);
        for (int i = 0; i < line3.length; i++) {
            HSSFCell cell5 = row5.createCell((short) i);
            cell5.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(line3[i]);
            cell5.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if(list!=null&&list.size()>0){
            int index=7;
            for(T t:list){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<column.length;i++){
                    Cell cell6 = row.createCell(i);
                    String filedName=column[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell6.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell6.setCellValue(textValue);
                        }
                    }

                }
            }
        }
    }


    public static <T> void threeExport(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, String[] columns, List<T> list, OutputStream out) throws Exception{
        //生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum,sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        //style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);

        //style.setFillBackgroundColor(HSSFColor.WHITE.index);
        //style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        //font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 10);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }

        //遍历集合数据，产生数据行
        if(list!=null&&list.size()>0){
            int index=1;
            for(T t:list){
                row=sheet.createRow(index);
                index++;
                for(short i=0;i<columns.length;i++){
                    Cell cell=row.createCell(i);
                    String filedName=columns[i];

                    JSONObject o = (JSONObject) JSONObject.toJSON(t);

                    Object value = o.get(filedName);
                    String textValue=value==null?"":value.toString();


                    if(textValue!=null){
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                    }

                }
            }
        }
    }


}
