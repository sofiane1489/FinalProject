package us.piit.utility;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {

    String filePath;

    public ExcelDataProvider(String path){
        this.filePath = path;
    }


//......................read data from single cell...................................................

    @DataProvider(name = "excelData")
    public Object[][] getExcelData(String sheetName,int rowNumber,int cellNumber) {
        Object[][] testData = null;

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            // Read data from the Excel file
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNumber);
            Cell cell = row.getCell(cellNumber);

            String cellData = getCellValueAsString(cell);

            testData = new Object[][]{{cellData}};

        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }

     String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else {
            return "";
        }
    }

    @Test(dataProvider = "excelData")
    public void testCellData(Object[][] data) {
        for (Object[] row : data) {
            for (Object cell : row) {
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }
    }
//................................. get the entire column data...............................................

        @DataProvider(name = "columnData")
        public Iterator<Object[]> getColumnData(String filePath, String sheetName,int columnIndex) {
            List<Object[]> testData = new ArrayList<>();

            try (FileInputStream fis = new FileInputStream(filePath);
                 Workbook workbook = WorkbookFactory.create(fis)) {

                Sheet sheet = workbook.getSheet(sheetName);
                int lastRowIndex = sheet.getLastRowNum();

                for (int i = 0; i <= lastRowIndex; i++) {
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(columnIndex);
                    String cellData = getCellValueAsString(cell);
                    testData.add(new Object[]{cellData});
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return testData.iterator();
        }

        @Test(dataProvider = "columnData")
        public void testColumnData(String columnData) {
            System.out.println("Column Data: " + columnData);
        }

//...................................read the entire file.............................................................


        @DataProvider(name = "fileData")
        public Iterator<Object[]> getFileData(String sheetName) {
            List<Object[]> testData = new ArrayList<>();

            try (FileInputStream fis = new FileInputStream(filePath);
                 Workbook workbook = WorkbookFactory.create(fis)) {

                Sheet sheet = workbook.getSheet(sheetName);
                int lastRowIndex = sheet.getLastRowNum();

                for (int i = 0; i <= lastRowIndex; i++) {
                    Row row = sheet.getRow(i);
                    int lastCellNum = row.getLastCellNum();
                    List<Object> rowData = new ArrayList<>();

                    for (int j = 0; j < lastCellNum; j++) {
                        Cell cell = row.getCell(j);
                        String cellData = getCellValueAsString(cell);
                        rowData.add(cellData);
                    }

                    testData.add(rowData.toArray());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return testData.iterator();
        }

//..................................................................................................

    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + File.separator + "data" + File.separator + "lumaData" + File.separator + "testcases.xlsx";

        ExcelDataProvider provider = new ExcelDataProvider(filePath);
        String sheetName = "luma";

       // get data from cell
        provider.testCellData(provider.getExcelData(sheetName,5,3));

        //get the entire column data
        Iterator<Object[]> iterator = provider.getColumnData(filePath,sheetName,3);
         while (iterator.hasNext()) {
            Object[] data = iterator.next();
            System.out.println("Column Data: " + data[0]);
        }

         //read the entire file
        Iterator<Object[]> iterator1 = provider.getFileData(sheetName);
         while (iterator1.hasNext()) {
            Object[] rowData = iterator1.next();
            for (Object cellData : rowData) {
                System.out.print(cellData + "\t");
            }
            System.out.println();
        }

    }

}

