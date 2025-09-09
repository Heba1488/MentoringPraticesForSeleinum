package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T02CalculatorOperation {
    //   Go to https://testpages.eviltester.com/styled/calculator
    //   Type any number in first and second input
    //   Click Calculate for each operation
    //   Get and verify results for all operations
        WebDriver driver;
        String url ="https://testpages.eviltester.com/styled/calculator";
        String num1 ="41";
        String num2 ="37";
        String [] operations ={"pluse","times","minus","divide"};

        By num1ById = By.id("number1");
        By num2ById = By.id("number2");
        By operationsDropDownById = By.id("funcation");
        By calculateButtonById = By.id("calculate");
        By  resultById = By.id("answer");


     @Test
     void test1(){
         driver.get(url);
         driver.findElement(num1ById).sendKeys(num1);
         driver.findElement(num2ById).sendKeys(num2);
         Select operations = new Select(driver.findElement(operationsDropDownById));
     }

    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
