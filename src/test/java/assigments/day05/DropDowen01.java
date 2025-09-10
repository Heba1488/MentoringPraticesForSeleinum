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
import java.util.List;

public class DropDowen01 {
    /*
    Launch browser
Open https://demoqa.com/select-menu
Select Old Style Select Menu using element id
Print all dropdown options
Select 'Purple' using index
Select 'Magenta' using visible text
Select an option using value
Close browse
     */
    WebDriver driver;

    String url ="https://demoqa.com/select-menu";

    @Test
    void To01(){
        //Open https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");
        //Select Old Style Select Menu using element id
        WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropdownElement);
        //Print all dropdown options
        List<WebElement> options = select.getOptions();
        System.out.println("Dropdown Options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        //Select 'Purple' using index
         select.selectByIndex(4);
        //Select 'Magenta' using visible text
        select.selectByVisibleText("Magenta");
        //Select an option using value
        select.selectByValue("6");


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
