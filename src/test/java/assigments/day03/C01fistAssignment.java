package assigments.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01fistAssignment {
    // Navigate to: https://opensource-demo.orangehrmlive.com/
   static  WebDriver driver;
   @BeforeEach
   void setUp(){
       driver = new ChromeDriver();
       driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
       driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   }

    // TODO: Locate username using absolute XPath
    String absoluteUsernameXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"; // Fill absolute path

    // TODO: Locate username using relative XPath
    String relativeUsernameXPath = "//input[@name='username']"; // Fill relative path
    // TODO: Locate password using both methods

       String absolutePasswordXPath ="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input";
       String relativePasswordXPath ="//input[@type='password']";
    // TODO: Locate login button using both methods
      String absoluteLogicButtonXpath ="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button";
       String relativeLogicButtonXpath="//button[@type='submit']";
    // TODO: Test both approaches work

    @Test
    void relativeXpathTest() {
        WebElement userName =driver.findElement(By.xpath(relativeUsernameXPath));
        WebElement password =driver.findElement(By.xpath(relativePasswordXPath));
        WebElement logicButton=driver.findElement(By.xpath(relativeLogicButtonXpath));
        userName.sendKeys("Admin");
        password.sendKeys("admin123");
        logicButton.click();
    }

    @Test
    void absoltuXpathTest() {
 WebElement userName =driver.findElement(By.xpath(absoluteUsernameXPath));
 WebElement password =driver.findElement(By.xpath(absolutePasswordXPath));
 WebElement logicButton=driver.findElement(By.xpath(absoluteLogicButtonXpath));
        userName.sendKeys("Admin");
        password.sendKeys("admin123");
        logicButton.click();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
