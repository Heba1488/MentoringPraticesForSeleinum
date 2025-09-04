package assigments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.text.Position;

public class Task03 {
    /*
    Task 3: Browser Size and Position
Setup:
Open Chrome in @BeforeEach.
Test 1:
Navigate to https://www.bbc.com.
Set browser size to 800x600 and assert the window size.
Test 2:
Move the window to position (100, 100) and assert its position.
Teardown:
Close the browser.
     */

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        System.out.println("Test execution .....");
    }


    @Test
    void task01(){
     driver.navigate().to("https://www.bbc.com");
     //expected size
     driver.manage().window().setSize(new Dimension(800,600));
     //current size
        Dimension dimension = driver.manage().window().getSize();

        int   width = dimension.getWidth();
        int height = dimension.getHeight();
        Assertions.assertEquals(800,width);
        Assertions.assertEquals(600,height);
    }


    @Test
    void task02(){
        driver.navigate().to("https://www.bbc.com");
        //expected size
        driver.manage().window().setPosition(new Point(100,100));
        //curent size
        Point point = driver.manage().window().getPosition();
        int pointX = point.getX();
        int pointY = point.getY();
        Assertions.assertEquals(100,pointX);
        Assertions.assertEquals(100,pointY);
    }
    @AfterEach
    void tearDown(){
        System.out.println("Test execution is over ....");
        driver.quit();
    }
}
