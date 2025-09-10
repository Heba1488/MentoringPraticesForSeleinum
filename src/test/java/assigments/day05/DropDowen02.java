package assigments.day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDowen02 {
    /*
    Launch browser
Open https://demoqa.com/select-menu
Select Standard Multi-Select using element id
Verify element is multi-select
Select 'Opel' using index, then deselect using index
Select 'Saab' using value, then deselect using value
Deselect all options
Close browser
     */
    WebDriver driver;

    String url ="https://demoqa.com/select-menu";

    @Test
    void selectMenu() throws InterruptedException {
        //Open https://demoqa.com/select-menu
        driver.get(url);
        //Select Standard Multi-Select using element id
         WebElement standardMultiSelect= driver.findElement(By.id("cars"));
         //Verify element is multi-select
           Select select = new Select(standardMultiSelect);
        System.out.println("standardMultiSelect" + select.isMultiple());
        //Select 'Opel' using index, then deselect using index
        select.selectByIndex(2);
        Thread.sleep(1000);
        select.deselectByIndex(2);
        //Select 'Saab' using value, then deselect using value
        select.selectByValue("saab");
        Thread.sleep(1000);
        select.deselectByValue("saab");
        //Deselect all options
        select.deselectAll();
        Thread.sleep(1000);
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
