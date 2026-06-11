package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getTestData(String sheetName) {

        Object[][] data = null;

        try {

            FileInputStream file =
                    new FileInputStream(
                            "testdata/BookingData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(file);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            int rowCount =
                    sheet.getPhysicalNumberOfRows();

            int colCount =
                    sheet.getRow(0)
                            .getPhysicalNumberOfCells();

            data =
                    new Object[rowCount - 1][colCount];

            DataFormatter formatter =
                    new DataFormatter();

            for (int i = 1; i < rowCount; i++) {

                for (int j = 0; j < colCount; j++) {

                    data[i - 1][j] =
                            formatter.formatCellValue(
                                    sheet.getRow(i)
                                            .getCell(j));
                }
            }

            workbook.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return data;
    }
}