package assigments.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C02SecondAssingment {
    String url = "https://testpages.herokuapp.com/styled/index.html";
// TODO: Navigate to test pages
    WebDriver driver;
    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterEach
    void tearDown()throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    void secondAssingment()
    {
        // TODO: Click on "Locators - Find By Playground Test Page"
        //find-by-playground-test.html
        driver.findElement(By.linkText("Locators - Find By Playground Test Page")).click();
        // TODO: Print current URL
        System.out.println(" Current url = " + driver.getCurrentUrl());
        // TODO: Navigate back
        driver.navigate().back();
        // TODO: Print URL after going back
        System.out.println("  Current url  After Back = " + driver.getCurrentUrl());

    }
@Test
    void T02(){
    // TODO: Click on "WebDriver Example Page"
    //webdriver-example-page
    driver.findElement(By.linkText("WebDriver Example Page")).click();
    // TODO: Print current URL
    System.out.println(" Current url = " + driver.getCurrentUrl());
    // TODO: Enter value 20 in number input
    driver.findElement(By.id("numentry")).sendKeys("20");
    driver.findElement(By.id("show-as-para")).sendKeys(Keys.ENTER);
    // TODO: Verify 'two, zero' message appears
    //id='show-as-para'
    String message = driver.findElement(By.id("message")).getAttribute("textContent");
    System.out.println("Message = " + message);
    Assertions.assertEquals("two, zero" , message);
}






}
