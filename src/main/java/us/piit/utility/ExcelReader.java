package us.piit.utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelReader {
    private final Logger LOG = LogManager.getLogger(ExcelReader.class.getName());

    XSSFWorkbook excelWBook;
    XSSFSheet excelWSheet;
    XSSFCell cell;
    String path;

    public ExcelReader(String path){
        this.path = path;
    }

    public String getDataFromCell(String sheet, int rowNum, int colNum){
        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheet);
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            String cellValue = cell.getStringCellValue();
            excelFile.close();
            return cellValue;
        }catch (Exception e){
            LOG.info("no file found");
            return "";
        }
    }

    public List<String> getEntireColumnData(String sheet, int rowStart, int colNum){
        List<String> columnData = new ArrayList<>();
        try {
            File file = new File(path);
            FileInputStream excelFile = new FileInputStream(file);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheet);
            for (int i = rowStart; i <= excelWSheet.getLastRowNum(); i++){
                columnData.add(excelWSheet.getRow(i).getCell(colNum).getStringCellValue());
            }
//            int i = rowStart;
//            while (excelWSheet.getRow(i).getCell(colNum).getStringCellValue() != null){
//                columnData.add(excelWSheet.getRow(i).getCell(colNum).getStringCellValue());
//                i++;
//            }
            excelFile.close();
        }catch (Exception e){
            e.printStackTrace();
            LOG.info("no data found");
        }
        return columnData;
    }

    public List<String> getEntireColumnForGivenHeader(String sheet, String headerName){
        int i = 0;
        while (getDataFromCell(sheet, 0, i) != null){
            if(getDataFromCell(sheet, 0, i).equalsIgnoreCase(headerName)){
                getEntireColumnData(sheet, 1, i);
                break;
            }
            i++;
        }
        return getEntireColumnData(sheet, 1, i);
    }

    public String getValueForGivenHeaderAndKey(String sheet, String headerName, String key){
        String value = null;
        int i = 0;
        while (getDataFromCell(sheet, 0, i) != null){
            if(getDataFromCell(sheet, 0, i).equalsIgnoreCase(headerName)){
                for (int j = 0; j < getEntireColumnData(sheet, 1, i).size(); j++){
                    if(getEntireColumnData(sheet, 1, i).get(j).equalsIgnoreCase(key)){
                        value = getEntireColumnData(sheet, 1, i+1).get(j);
                    }
                }
                break;
            }
            i++;
        }
        return value;
    }


    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\sehso\\eclipse-workspace\\FinalProject\\data\\lumaData\\LumaTestCases.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        String name="Sheet1";
       // String data=excelReader.getDataFromCell(name,2,1);
       // System.out.println(data);
 //         List<String> items = excelReader.getEntireColumnForGivenHeader("Sheet1", "Project Name");
      //   String items = excelReader.getValueForGivenHeaderAndKey("Sheet1", "Project Name", "Created by");
//           List<String> items = excelReader.getEntireColumnData("Sheet1", 4,4);
//           System.out.println(items);


    }
}
