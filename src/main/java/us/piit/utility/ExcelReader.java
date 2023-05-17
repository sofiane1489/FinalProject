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



 //...............................................................................................//
 //....................................................................................................//


    public void getCellData(int rowIndex,int columnIndex) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(path));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read from the first sheet

        // Specify the row and column indices of the cell you want to read

        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(columnIndex);

        // Retrieve the value from the cell based on its type
        String cellValue = "";
        if (cell.getCellType() == CellType.STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            cellValue = String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            cellValue = String.valueOf(cell.getBooleanCellValue());
        }

        System.out.println(cellValue);

        workbook.close();
        inputStream.close();
    }

    public void readEntireColomn(int columnIndex) throws IOException {
        //String filePath = "path/to/excel/file.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(path));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read from the first sheet

        // Iterate over each row in the column
        for (Row row : sheet) {
            Cell cell = row.getCell(columnIndex);

            // Retrieve the value from the cell based on its type
            String cellValue = "";
            if (cell != null) {
                if (cell.getCellType() == CellType.STRING) {
                    cellValue = cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                } else if (cell.getCellType() == CellType.BOOLEAN) {
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                }
            }

            System.out.println(cellValue);
        }

        workbook.close();
        inputStream.close();
    }

    public void rearEntireColomnForGivenHeader(String headerName,int rowStart) throws IOException {

        FileInputStream inputStream = new FileInputStream(new File(path));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read from the first sheet

        // Find the column index based on the header name
        int columnIndex = -1;
        Row headerRow = sheet.getRow(rowStart);
        for (Cell cell : headerRow) {
            String cellValue = cell.getStringCellValue();
            if (cellValue.equalsIgnoreCase(headerName)) {
                columnIndex = cell.getColumnIndex();
                break;
            }
        }

        if (columnIndex != -1) {
            // Iterate over each row in the column
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                Cell cell = row.getCell(columnIndex);

                // Retrieve the value from the cell based on its type
                String cellValue = "";
                if (cell != null) {
                    if (cell.getCellType() == CellType.STRING) {
                        cellValue = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                    }
                }

                System.out.println(cellValue);
            }
        } else {
            System.out.println("Header not found.");
        }

        workbook.close();
        inputStream.close();
    }


    public void readEntireFile() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(path));

        Workbook workbook = new XSSFWorkbook(inputStream);

        // Iterate over each sheet in the workbook
        for (Sheet sheet : workbook) {
            System.out.println("Sheet Name: " + sheet.getSheetName());
            System.out.println("----------------------------");

            // Iterate over each row in the sheet
            for (Row row : sheet) {
                // Iterate over each cell in the row
                for (Cell cell : row) {
                    // Retrieve the value from the cell based on its type
                    String cellValue = "";
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            cellValue = cell.getStringCellValue();
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            cellValue = String.valueOf(cell.getNumericCellValue());
                        } else if (cell.getCellType() == CellType.BOOLEAN) {
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                        }
                    }

                    System.out.println(cellValue);
                }
                System.out.println();
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();
    }



    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\sehso\\eclipse-workspace\\FinalProject\\data\\lumaData\\LumaTestCases.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        String name="data";
        String data=excelReader.getDataFromCell(name,2,1);
        System.out.println(data);
 //         List<String> items = excelReader.getEntireColumnForGivenHeader("data", "Project Name");
      //   String items = excelReader.getValueForGivenHeaderAndKey("data", "Project Name", "Created by");
//           List<String> items = excelReader.getEntireColumnData("data", 4,4);
//           System.out.println(items);

//.......................................................................................................
//.......................................................................................................

//         excelReader.getCellData(1,1);
//         excelReader.readEntireColomn(2);
//         excelReader.rearEntireColomnForGivenHeader("Test Steps",6);
//         excelReader.readEntireFile();
    }
}
