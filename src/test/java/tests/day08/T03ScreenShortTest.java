package tests.day08;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class T03ScreenShortTest extends TestBase {
    /*
Go to https://claruswaysda.github.io/homepage.html
Register a user
Sign in with the registered user
Take all pages' screenshots
Take 'Celebrate Login' button's screenshot.
Capture a screenshot of the page with confetti.
*/
    @Test
    public void T03ScreenShortTest() throws IOException {
        //Go to https://claruswaysda.github.io/homepage.html
        driver.get("https://claruswaysda.github.io/homepage.html");
        //Register a user
        driver.findElement(By.id("userIcon")).click();
        driver.findElement(By.linkText("Register")).click();
        //Sign in with the registered user
        driver.findElement(By.id("ssn")).sendKeys("000");
        driver.findElement(By.id("first-name")).sendKeys("Heba");
        driver.findElement(By.id("last-name")).sendKeys("ALahmadi");
        driver.findElement(By.id("address")).sendKeys("Heba");
        driver.findElement(By.id("phone")).sendKeys("Heba");
        driver.findElement(By.id("username")).sendKeys("12345");
        driver.findElement(By.id("email")).sendKeys("12345");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("confirm-password")).sendKeys("12345");
        driver.findElement(By.cssSelector("button")).click();

        //Take all pages' screenshots
        TakesScreenshot ss =  (TakesScreenshot)driver;
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        File screenShot = ss.getScreenshotAs(OutputType.FILE);
        Path path2 = Path.of(System.getProperty("user.dir"),"screenshot","allScrenshot.png");
        Path path1 = Path.of(System.getProperty("user.dir"),"target","test-output","screenshot","allScrenshot"+timeStamp+".png");
        Path path = Path.of(System.getProperty("user.home"),"Desktop","test-output","screenshot","Screnshot"+timeStamp+".png");
        FileUtils.copyFile(screenShot,path.toFile());
    }


}
