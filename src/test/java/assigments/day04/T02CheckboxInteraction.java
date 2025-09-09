package assigments.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T02CheckboxInteraction {
      /*
    Task: Go to "https://the-internet.herokuapp.com/checkboxes"
.   Write a method that:

    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console */

    WebDriver driver;
    String url ="https://the-internet.herokuapp.com/checkboxes";
    By checkBox1ByXpath = By.xpath("//input[@type='checkbox'][1]");
    By checkBox2ByXpath = By.xpath("//input[@type='checkbox'][2]");
    By checkBoxesByXpath = By.xpath("//input[@type='checkbox']");
     @Test
     void checkboxInteraction(){
         //Go to "https://the-internet.herokuapp.com/checkboxes"
         driver.navigate().to(url);
         //Checks the current state of both checkboxes
         WebElement checkBox1 = driver.findElement(checkBox1ByXpath);
         WebElement checkBox2 = driver.findElement(checkBox2ByXpath);
         System.out.println("Checkbox 1 selected? " + checkBox1.isSelected());
         System.out.println("Checkbox 2 selected? " + checkBox2.isSelected());
         //Ensures both checkboxes are selected (click only if not already selected)
         if (!checkBox1.isSelected()) checkBox1.click();
         if (!checkBox2.isSelected()) checkBox2.click();
        //Verify both checkboxes are checked after the operations
         Assertions.assertTrue(checkBox1.isSelected());
         Assertions.assertTrue(checkBox2.isSelected());
      //Print the status of each checkbox to console
         System.out.println("Checkbox 1 selected? " + checkBox1.isSelected());
         System.out.println("Checkbox 2 selected? " + checkBox2.isSelected());
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
