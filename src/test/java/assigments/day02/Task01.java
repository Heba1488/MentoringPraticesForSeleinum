package assigments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01
{
    /*
    Task 1: Browser History Exploration
‏Setup:
‏Use @BeforeEach to launch Chrome and maximize.
‏Test 1:
‏Navigate to https://www.wikipedia.org.
‏Navigate to https://www.google.com.
‏Navigate back and forward multiple times, asserting the correct title at each step.
‏Test 2:
‏Use driver.navigate().refresh() on Google and assert the title still contains "Google".
‏Teardown:
‏Use @AfterEach to close the browser.
     */
     WebDriver driver;
    @BeforeEach
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Test is running");
    }
    @Test
    public void Task01()
    {
        driver.navigate().to("https://www.wikipedia.org");
         String titleAdress1 = driver.getTitle();
         System.out.println("Title adress is: " + titleAdress1);

        driver.navigate().to("https://www.google.com");
        String titleAdress2 = driver.getTitle();
        System.out.println("Title adress is: " + titleAdress2);

        driver.navigate().back();
        Assertions.assertTrue(titleAdress1.contains("Wikipedia"));
        driver.navigate().forward();
        Assertions.assertTrue(titleAdress2.contains("Google"));

    }

    @Test
    public void Task02()
    {
         driver.navigate().to("https://www.google.com");
        String beforeRefresh=driver.getTitle();
        System.out.println("Title adress is: " + beforeRefresh);
        driver.navigate().refresh();
        String afterRefresh=driver.getTitle();
        Assertions.assertTrue(afterRefresh.contains("Google"));
    }


    @AfterEach
    public void tearDown()
    {
        driver.quit();
        System.out.println("Test execution is over ....");
    }
}
