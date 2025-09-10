package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DeletedChar {
    WebDriver driver;
    String url ="https://claruswaysda.github.io/deleteChars.html";
    String Yourname ="Heba";

    @Test
    void deleteChar() throws InterruptedException {
        driver.get(url);
        // 2. Enter full name
        WebElement inputField = driver.findElement(By.id("inputText"));
        inputField.sendKeys(Yourname);
        // 3. Click delete button until 'Deleted' message appears
        WebElement deleteBtn = driver.findElement(By.id("deleteButton"));
        WebElement message = driver.findElement(By.id("deletedMessage"));
       int i =0;
        while (!message.getText().equals("Deleted") &&  i < Yourname.length()) {
            deleteBtn.click();
            Thread.sleep(200);
            i++;
        }

        // 4. Verify the message
        Assertions.assertEquals("Deleted", message.getText());
    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
