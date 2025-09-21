package tests;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class C47WriteEcel03 {
    private static final Path EMPLOYEESPATH = Path.of(".", "resources", "Employees.xlsx");

    @Test
    public void addNewNameLastNameTest() throws FileNotFoundException {
       Workbook workbook;
        try( FileInputStream fis = new FileInputStream(EMPLOYEESPATH.toString())){
         workbook = WorkbookFactory.create(fis);
        }catch (Exception e){
           throw new RuntimeException(e);
        }
         Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < 5; i++) {
            sheet.createRow(sheet.getLastRowNum()+1).createCell(i).setCellValue(Faker.instance().name().firstName());
            sheet.createRow(sheet.getLastRowNum()).createCell(1).setCellValue(Faker.instance().name().lastName());
        }

    }

    private void addNewEmployee(String name, String lastname) throws IOException {

    }
}
