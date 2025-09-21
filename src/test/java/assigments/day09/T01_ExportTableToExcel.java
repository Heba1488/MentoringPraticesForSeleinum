package assigments.day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class T01_ExportTableToExcel  extends TestBase {
    /*
Go to https://claruswaysda.github.io/webTable.html
Write the entire Table 1 to a new Excel sheet.
*/
    @Test
    public void exportTableToExcel() throws IOException {
        //Go to https://claruswaysda.github.io/webTable.html
        driver.get("https://claruswaysda.github.io/webTable.html");
        //locater the Tabel 1
        WebElement table1 =driver.findElement(By.id("t1"));
        //create list to add row
        List<WebElement> rows = table1.findElements(By.tagName("tr"));
        //create Workbook
        Workbook workbook = WorkbookFactory.create(true);

        Sheet sheet = workbook.createSheet("Table1");
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);

            List<WebElement> cells = rows.get(i).findElements(By.xpath(".//th|.//td"));
            for (int j = 0; j < cells.size(); j++) {
                Cell excelCell = excelRow.createCell(j);
                excelCell.setCellValue(cells.get(j).getText());
            }
        }

        FileOutputStream fileOut = new FileOutputStream(Path.of(".","resources","ExportTableToExcel.xlsx").toString());
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
