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
import java.util.List;

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
    void testRadioButtons() {


//        Attempts to select each radio button (Yes, Impressive, No)
            By yesRadioButton = By.xpath("//p/input");
            By impressiveRadioButton = By.xpath("(//p/input)[2]");
            By noRadioButton = By.xpath("(//p/input)[3]");

            List<WebElement> checkBoxes = driver.findElements(yesRadioButton);

            for (WebElement checkBox : checkBoxes) {
                checkBox.click();
                Assertions.assertTrue(checkBox.isSelected());
            }


            driver.findElement(yesRadioButton).click();
            System.out.println(driver.findElement(yesRadioButton).isSelected());
            System.out.println(driver.findElement(impressiveRadioButton).isSelected());
            System.out.println(driver.findElement(noRadioButton).isSelected());


            driver.findElement(impressiveRadioButton).click();
            System.out.println(driver.findElement(yesRadioButton).isSelected());
            System.out.println(driver.findElement(impressiveRadioButton).isSelected());
            System.out.println(driver.findElement(noRadioButton).isSelected());

            driver.findElement(noRadioButton).click();
            System.out.println(driver.findElement(yesRadioButton).isSelected());
            System.out.println(driver.findElement(impressiveRadioButton).isSelected());
            System.out.println(driver.findElement(noRadioButton).isSelected());


        }


        @AfterEach
        public void tearDown () throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }

    }
