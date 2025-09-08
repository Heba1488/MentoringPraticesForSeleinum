package tests.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class T03RadioButtonSelection {

    /*
   Task: Navigate to "http://test.rubywatir.com/radios.php"
    . Create a test that:

    Attempts to select each radio buttonand verify it (click them all)
    Print confirmation message for each successful selection
    */


    static WebDriver driver;
    @BeforeEach
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.rubywatir.com/radios.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void testRadioButtons(){
        WebElement yesOption = driver.findElement(By.id("yesRadio"));
        yesOption.click();
        Assertions.assertTrue(yesOption.isSelected());
        WebElement noOption = driver.findElement(By.id("noRadio"));
       /* noOption.click();
        Assertions.assertFalse(noOption.isSelected());*/
       // WebElement impressiveRadio = driver.findElement(By.cssSelector());
       // impressiveRadio.click();
       // Assertions.assertTrue(impressiveRadio.isSelected());
   ////input[@class='radioclass']
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
