package com.hl.hardwareLibrary.utils;


import com.google.common.primitives.Doubles;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * xlsx 工具
 */
public class XlsxUtils {

    public static String parseExcel(Cell cell) {
        String result;
        if(null==cell){
            return "";
        }

        switch (cell.getCellType()) {
            case NUMERIC:// 数字类型
                if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                            .getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date = cell.getDateCellValue();
                    result = sdf.format(date);
                } else if (cell.getCellStyle().getDataFormat() == 58) {
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    double value = cell.getNumericCellValue();
                    Date date = DateUtil
                            .getJavaDate(value);
                    result = sdf.format(date);
                } else {
                    double value = cell.getNumericCellValue();

                    if(value % 1 == 0){
                        CellStyle style = cell.getCellStyle();
                        DecimalFormat format = new DecimalFormat();
                        String temp = style.getDataFormatString();
                        // 单元格设置成常规
                        if (temp.equals("General")) {
                            format.applyPattern("#");
                        }
                        result = format.format(value);
                    }else {
                        result = String.valueOf(value);
                    }

                }
                break;

            case FORMULA:

                try {
                    result = String.valueOf(cell.getNumericCellValue());
                } catch (Exception e) {
                    result = String.valueOf(cell.getRichStringCellValue());
                }
                break;

            case STRING:// String类型
                result = cell.getRichStringCellValue().toString();
                break;
            case BLANK:
                result = "";
            default:
                result = "";
                break;
        }
        return result;
    }

    public static void exportExcelx(String title, String[] headers, String[] columns,
                                     List<Map> list, OutputStream out, String pattern) throws NoSuchMethodException, Exception{
        //创建工作薄
        XSSFWorkbook workbook=new XSSFWorkbook();
        //创建表格
        Sheet sheet=workbook.createSheet(title);
        //设置默认宽度
        sheet.setDefaultColumnWidth(25);
        //创建样式
        XSSFCellStyle style=workbook.createCellStyle();
        //设置样式
        style.setFillForegroundColor(IndexedColors.GOLD.index);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //生成字体
        XSSFFont font=workbook.createFont();
        font.setColor(IndexedColors.VIOLET.index);
        //font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        //应用字体
        style.setFont(font);

        //自动换行
        style.setWrapText(true);
        //声明一个画图的顶级管理器
        Drawing drawing=(XSSFDrawing) sheet.createDrawingPatriarch();

        Row row=sheet.createRow(0);
        for(int i=0;i<headers.length;i++){
            Cell cell=row.createCell(i);
            cell.setCellStyle(style);
            XSSFRichTextString text=new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
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
                    /*String getMethodName="get"+filedName.substring(0,1).toUpperCase(Locale.ENGLISH)
                            +filedName.substring(1);
                    Class tCls=t.getClass();
                    Method getMethod=tCls.getMethod(getMethodName,new Class[]{});
                    Object value=getMethod.invoke(t, new Class[]{});*/
                    Object value = map.get(filedName);
                    String textValue=null;
                    if(value==null){
                        textValue="";
                    }else if(value instanceof Date){
                        Date date=(Date)value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    }else if(value instanceof byte[]){
                        row.setHeightInPoints(80);
                        sheet.setColumnWidth(i, 35*100);
                        byte[] bsValue=(byte[])value;
                        XSSFClientAnchor anchor=new XSSFClientAnchor(0,0,1023,255,6,index,6,index);
                       // anchor.setAnchorType(2);
                        drawing.createPicture(anchor, workbook.addPicture(bsValue, XSSFWorkbook.PICTURE_TYPE_JPEG));
                    }else{
                        // 其它数据类型都当作字符串简单处理
                        textValue=value.toString();
                    }

                    if(textValue!=null){
                        /*Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);*/
                        Double d = Doubles.tryParse(textValue);
                        if (null!=d) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            XSSFRichTextString richString = new XSSFRichTextString(
                                    textValue);
                            // HSSFFont font3 = workbook.createFont();
                            // font3.setColor(HSSFColor.BLUE.index);
                            // richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }

                }
            }
        }
        workbook.write(out);
    }

    public static XSSFWorkbook exportExcel(String[] headers,String[] columns,List<Map> list,String pattern) {
        try {

            // 第一步，创建一个workbook，对应一个Excel文件
            XSSFWorkbook wb = new XSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            XSSFSheet sheet = wb.createSheet("sheet1");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            XSSFRow row = sheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            XSSFCellStyle style = wb.createCellStyle();
            // 设置这些样式
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            style.setBorderRight(BorderStyle.THIN);
            style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
            style.setBorderLeft(BorderStyle.THIN);
            style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
            style.setBorderTop(BorderStyle.THIN);
            style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
            style.setBorderBottom(BorderStyle.THIN);
            style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

            // 生成一个字体
            XSSFFont font = wb.createFont();
            //font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short) 10);
            //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

            // 把字体应用到当前的样式
            style.setFont(font);

            // 产生表格标题行
            //String[] arrHeader = headers.split(",", 0);

            for (int i = 0; i < headers.length; i++) {
                sheet.setColumnWidth(i, 18 * 256);
                XSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                XSSFRichTextString text = new XSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            //遍历集合数据，产生数据行
            if(list!=null&&list.size()>0){
                for(int i = 0; i < list.size(); i++){
                    row = sheet.createRow(i + 1);
                    for(short j=0;j<columns.length;j++){
                        String filedName=columns[j];
                        Object value = list.get(i).get(filedName);
                        row.createCell(j).setCellValue(value.toString());
                    }
                }
            }


         /*   // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 1);

                String[] rowArr = new String[4];

                for (int j = 0; j < rowArr.length; j++) {
                    // 第四步，创建单元格，并设置值
                    row.createCell(j).setCellValue(rowArr[j]);
                }
            }*/
            // 第六步，将文件存到指定位置

            //FileOutputStream fout = new FileOutputStream("D:/excel/" + title + ".xls");
            //wb.write(fout);
            //fout.close();

            return wb;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HSSFWorkbook exportXls(String[] headers,String[] columns,List<Map> list,String pattern) {
        try {

            // 第一步，创建一个workbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet("sheet1");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle();
            // 设置这些样式
			/*style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);*/
            style.setAlignment(HorizontalAlignment.CENTER);// 居中

            // 生成一个字体
            HSSFFont font = wb.createFont();
            //font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short) 10);
            //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

            // 把字体应用到当前的样式
            style.setFont(font);

            // 产生表格标题行
            //String[] arrHeader = headers.split(",", 0);

            for (int i = 0; i < headers.length; i++) {
                sheet.setColumnWidth(i, 18 * 256);
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            //遍历集合数据，产生数据行
            if(list!=null&&list.size()>0){
                for(int i = 0; i < list.size(); i++){
                    row = sheet.createRow(i + 1);
                    for(short j=0;j<columns.length;j++){
                        String filedName=columns[j];
                        Object value = list.get(i).get(filedName);
                        row.createCell(j).setCellValue(value.toString());
                    }
                }
            }

            return wb;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}