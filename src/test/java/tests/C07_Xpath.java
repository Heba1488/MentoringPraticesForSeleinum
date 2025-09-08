package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_Xpath {
    WebDriver driver;
    @BeforeEach
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

    }



    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



    @Test
    void absoluteXPathTest() {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/form/p[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/p[2]/input"));
        emailInput.sendKeys("johndoeSDA@yahoo.com");
        passwordInput.sendKeys("John.123", Keys.ENTER);
    }

   @Test
    void relativeXpathTest()
    {
     WebElement emailInput=  driver.findElement(By.xpath("//input[@placeholder='Email']"));
     WebElement passwordInput=  driver.findElement(By.xpath("//input[@placeholder='Password']"));
     emailInput.sendKeys("johndoeSDA@yahoo.com");
     passwordInput.sendKeys("John.123", Keys.ENTER);

    }


}
