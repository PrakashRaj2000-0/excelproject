package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;

    public static void setExcelFile(String path) throws IOException {
        FileInputStream file = new FileInputStream(path);
        workbook = WorkbookFactory.create(file);
    }

    public static Object[][] getTableArray(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.getStringCellValue();
            }
        }
        return data;
    }
}
