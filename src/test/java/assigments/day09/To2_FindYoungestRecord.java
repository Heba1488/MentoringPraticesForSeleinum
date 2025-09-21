package assigments.day09;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.util.List;

public class To2_FindYoungestRecord extends TestBase {
    /*
Go to https://claruswaysda.github.io/addRecordWebTable.html
Add 10 records using Faker.
Find the name of the youngest record.
*/

    @Test
    public void To2_FindYoungestRecord() {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        Faker faker = new Faker();
        Select countrySelect = new Select(driver.findElement(By.id("countrySelect")));
        List<WebElement> countryOptions = countrySelect.getOptions();


        // Add 10 records
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("nameInput")).sendKeys(faker.name().firstName());
            driver.findElement(By.id("ageInput")).sendKeys(String.valueOf(faker.number().numberBetween(18, 70)));
            countrySelect.selectByIndex(faker.number().numberBetween(1, countryOptions.size()));
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();


        }

        // Find youngest
        List<WebElement> names = driver.findElements(By.xpath("//tbody[@id='tableBody']//tr/td[1]"));
        List<WebElement> ages = driver.findElements(By.xpath("//tbody[@id='tableBody']//tr/td[2]"));

        String youngestName = "";
        int minAge = Integer.MAX_VALUE;
        for (int i = 0; i < ages.size(); i++) {
            int age = Integer.parseInt(ages.get(i).getText());
            if (age < minAge) {
                minAge = age;
                youngestName = names.get(i).getText();

            }
        }

        System.out.println("Youngest person: " + youngestName + " Age: " + minAge);
    }
}
