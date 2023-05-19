package us.piit.utility;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ExcelDataProvider {

    String filePath;
    public ExcelDataProvider(String path){
        this.filePath = path;
    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData(String sheetName,int rowNumber,int cellNumber) {
        // Path to your Excel file
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

    private String getCellValueAsString(Cell cell) {
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
    public static void main(String[] args) {

        String filePath = "C:\\Users\\sehso\\eclipse-workspace\\FinalProject\\data\\lumaData\\testcases.xlsx";
        ExcelDataProvider provider = new ExcelDataProvider(filePath);
        String sheetName = "luma"; // Assuming the sheet name is "Sheet1"

         //Run the test method
        provider.testCellData(provider.getExcelData(sheetName,5,4));


    }
}
