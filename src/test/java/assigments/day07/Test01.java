package assigments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class Test01  extends TestBase {
    /*
Go to https://claruswaysda.github.io/
Click on Window Handle
Click on 'Open Index Page'
Verify the link 'https://claruswaysda.github.io/index.html'
*/

    String url = "https://claruswaysda.github.io/";

    @Test
    public void Test01() {
        //Go to https://claruswaysda.github.io/
        driver.get("https://claruswaysda.github.io/");

        //  Click on Window Handle
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Window Handle")).click();

        //  (windowhandle.html)
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        //Click on 'Open Index Page'
        WebElement openIndexPage = driver.findElement(By.id("openIndex"));
        openIndexPage.click();

        // switch index.html
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow) && !handle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(handle);
                break;
            }
        }

         //Verify the link 'https://claruswaysda.github.io/index.html'
        Assertions.assertEquals("https://claruswaysda.github.io/index.html",
                driver.getCurrentUrl());
    }
}
