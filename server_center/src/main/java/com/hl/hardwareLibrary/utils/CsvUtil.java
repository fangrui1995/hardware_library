package com.hl.hardwareLibrary.utils;

/**
 * @Classname CSVUtil
 * @Description CSV工具类
 * @Author wanghd
 * @Date 2021/2/20
 */

import cn.hutool.core.text.csv.CsvWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 导出至csv文件
 * */
@Slf4j
public class CsvUtil {
    //CSV文件分隔符
    private final static String NEW_LINE_SEPARATOR="\n";
    /** CSV文件列分隔符 */
    private static final String CSV_COLUMN_SEPARATOR = ",";
    /** CSV文件列分隔符 */
    private static final String CSV_RN = "\r\n";

    /**写入csv文件
     * @param headers 列头
     * @param data 数据内容
     * @param filePath 创建的csv文件路径
     * @throws IOException **/
    public static void writeCsvWithHeader(String[] headers, List<Object[]> data, String filePath) {
        //初始化csvformat
        CSVFormat format = CSVFormat.DEFAULT.withHeader(headers);
        OutputStreamWriter osw = null;
        try {
            //根据路径创建文件，并设置编码格式
            FileOutputStream fos = new FileOutputStream(filePath);
            osw = new OutputStreamWriter(fos, "GBK");
            //创建CSVPrinter对象
            CSVPrinter printer = new CSVPrinter(osw, format);

            if(null!=data){
                //循环写入数据
                for(Object[] lineData:data){
                    printer.printRecord(lineData);
                }
            }
            printer.flush();
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=osw){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**写入csv文件
     * @param headers 列头
     * @param data 数据内容
     * @param filePath 创建的csv文件路径
     * @throws IOException **/
    public static void writeCsvWithRecordSeparator(Object[] headers, List<String[]> data, String filePath){
        //初始化csvformat
        CSVFormat format = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        OutputStreamWriter osw = null;
        try {
            //根据路径创建文件，并设置编码格式
            FileOutputStream fos = new FileOutputStream(filePath);
            osw = new OutputStreamWriter(fos, "GBK");
            //创建CSVPrinter对象
            CSVPrinter printer = new CSVPrinter(osw,format);
            //写入列头数据
            printer.printRecord(headers);

            if(null != data){
                //循环写入数据
                for(String[] lineData:data){
                    printer.printRecord(lineData);
                }
            }
            printer.flush();
            printer.close();
            log.info("CSV文件创建成功,文件路径:" + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=osw){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void downloadCsv(HttpServletResponse response,String[] headers, List<String[]> data) throws IOException {
        CsvWriter cw = new CsvWriter(response.getWriter());
        List<String[]> dataList = new ArrayList<>();
        dataList.add(headers);
        for(String[] singleData : data){
            dataList.add(singleData);
        }
        cw.write(dataList);
        cw.flush();
        cw.close();
    }

    public static void createFixationSheet(OutputStream os,
                                           String[] headers, List<String[]> data) throws Exception {
        // 创建工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        // 在工作薄上建一张工作表
        HSSFSheet sheet = wb.createSheet();
        int startNumber = 0;
        HSSFRow row = sheet.createRow(startNumber);
        sheet.createFreezePane(0, 1);
        HSSFCellStyle cellstyle = wb.createCellStyle();
        for(int i = 0;i < headers.length;i++){
            cteateCell(wb, row, i, headers[i].toString(),cellstyle);
        }
        if(CollectionUtils.isNotEmpty(data)){
            for(Object[] objects : data){
                HSSFRow rowi = sheet.createRow((++startNumber));
                for (int j = 0; j < objects.length; j++) {
                    cteateCell(wb, rowi, j, objects[j] == null ? null : objects[j].toString(),cellstyle);
                }
            }
        }
        wb.write(os);
        os.flush();
        os.close();

    }

    public static void createCsv(HttpServletResponse response,
                                 String[] headers, List<String[]> data){
        try {
            CsvWriter cw = new CsvWriter(response.getWriter());
            List<String[]> resultList = new ArrayList<>();
            resultList.add(headers);
            resultList.addAll(data);
            cw.write(resultList);
            cw.flush();
            cw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("deprecation")
    private static void cteateCell(HSSFWorkbook wb, HSSFRow row, int col,
                            String val,HSSFCellStyle cellstyle) {
        HSSFCell cell = row.createCell(col);
        cell.setCellValue(val);
        cell.setCellStyle(cellstyle);
    }

    /**
     * @filePath 文件路径
     */
    public static List<CSVRecord> readCsvParse(String filePath){
        List<CSVRecord> records = new ArrayList<>();
        BufferedReader reader = null;
        try {
            FileInputStream in = new FileInputStream(filePath);
            reader = new BufferedReader (new InputStreamReader(in,"GBK"));
            CSVParser parser = CSVFormat.EXCEL.parse(reader);
            records = parser.getRecords();
            parser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return records;
    }

    /**
     * 自定义字段
     * @filePath 文件路径
     */
    public static List<CSVRecord> readCsvParseWithHeader(String filePath,String[] headers){
        List<CSVRecord> records = new ArrayList<>();
        try {
            FileInputStream in = new FileInputStream(filePath);
            BufferedReader  reader = new BufferedReader (new InputStreamReader(in,"GBK"));
            CSVParser parser = CSVFormat.EXCEL.withHeader(headers).parse(reader);
            records = parser.getRecords();
            /*for (CSVRecord record : parser.getRecords()) {
                log.info(record.get("id") + ","
                        + record.get("name") + ","
                        + record.get("code"));
            }*/
            parser.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return records;
    }

    /**
     * @param colNames 表头部数据
     * @param dataList 集合数据
     * @param mapKeys 查找的对应数据
     */
    public static ByteArrayOutputStream doExport(String[] colNames, String[] mapKeys, List<Map> dataList) {
        try {
            StringBuffer buf = new StringBuffer();

            // 完成数据csv文件的封装
            // 输出列头
            for (int i = 0; i < colNames.length; i++) {
                buf.append(colNames[i]).append(CSV_COLUMN_SEPARATOR);
            }
            buf.append(CSV_RN);

            if (null != dataList) { // 输出数据
                for (int i = 0; i < dataList.size(); i++) {
                    for (int j = 0; j < mapKeys.length; j++) {
                        buf.append(dataList.get(i).get(mapKeys[j])).append(CSV_COLUMN_SEPARATOR);
                    }
                    buf.append(CSV_RN);
                }
            }
            // 写出响应
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            //OutputStream os = new ByteArrayOutputStream();
            os.write(buf.toString().getBytes("UTF-8"));
            os.flush();
            os.close();
            InputStream oos = new ByteArrayInputStream(os.toByteArray());
            return os;
        } catch (Exception e) {
            log.error("doExport错误...", e);
            e.printStackTrace();
        }
        return null;
    }

    public static HttpHeaders setCsvHeader(String fileName) {
        HttpHeaders headers = new HttpHeaders();
        try {
            // 设置文件后缀
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String filename = new String(fileName.getBytes("gbk"), "iso8859-1") + sdf.format(new Date()) + ".csv";
            headers.add("Pragma", "public");
            headers.add("Cache-Control", "max-age=30");
            headers.add("Content-Disposition", "attachment;filename="+filename);
            headers.setContentType(MediaType.valueOf("application/vnd.ms-excel;charset=UTF-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return headers;
    }

}
