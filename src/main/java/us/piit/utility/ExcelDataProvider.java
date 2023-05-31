package us.piit.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    public Iterator<Object[]> getColumnData(String filePath, String sheetName, int COLUMN_INDEX) {
        List<Object[]> testData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int lastRowIndex = sheet.getLastRowNum();

            for (int i = 0; i <= lastRowIndex; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(COLUMN_INDEX);
                    if (cell != null) {
                        String cellData = getCellValueAsString(cell);
                        if (!cellData.isEmpty()) {
                            testData.add(new Object[]{cellData});
                        }
                    }
                }
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
        public Iterator<Object[]> getFileData(String filePath, String sheetName) {
            List<Object[]> testData = new ArrayList<>();

            try (FileInputStream fis = new FileInputStream(filePath);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheet(sheetName);
                int lastRowIndex = sheet.getLastRowNum();

                for (int i = 0; i <= lastRowIndex; i++) {
                    Row row = sheet.getRow(i);
                    if (row != null && !isRowEmpty(row)) {
                        int lastCellIndex = row.getLastCellNum();
                        Object[] rowData = new Object[lastCellIndex];

                        for (int j = 0; j < lastCellIndex; j++) {
                            Cell cell = row.getCell(j);
                            rowData[j] = getCellValueAsString(cell);
                        }

                        testData.add(rowData);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return testData.iterator();
        }

        @Test(dataProvider = "fileData")
        public void testFileData(Object[] rowData) {
            if (rowData != null) {
                System.out.println("Row Data: " + java.util.Arrays.toString(rowData));
            }
        }

        private boolean isRowEmpty(Row row) {
            for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    return false;
                }
            }
            return true;
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
        Iterator<Object[]> iterator = provider.getColumnData(filePath,sheetName,1);
        while (iterator.hasNext()) {
            Object[] data = iterator.next();
            if (data != null && data.length > 0) {
                System.out.println(data[0]);
            }
        }


         //read the entire file
        Iterator<Object[]> iterator1 = provider.getFileData(filePath,sheetName);
         while (iterator1.hasNext()) {
            Object[] rowData = iterator1.next();
            for (Object cellData : rowData) {
                System.out.print(cellData + "\t");
            }
            System.out.println();
        }

    }

}

