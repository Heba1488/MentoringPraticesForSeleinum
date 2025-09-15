package assigments.day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Teast02 extends TestBase {
    /*
Go to URL: http://demo.guru99.com/test/guru99home/
1. Find the number of iframes on the page
2. Switch to the third iframe (JMeter Made Easy)
3. Click the link (https://www.guru99.com/live-selenium-project.html)
4. Exit the iframe and return to the main page
*/

    String uri ="http://demo.guru99.com/test/guru99home/";
    @Test
    public void T02()
    {
        //Go to URL: http://demo.guru99.com/test/guru99home/
        driver.navigate().to(uri);
        //Find the number of iframes on the page
        int frameCount = driver.findElements(By.tagName("iframe")).size();
        //Switch to the third iframe (JMeter Made Easy)
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().frame("a077aa5e");
        //Click the link (https://www.guru99.com/live-selenium-project.html)
        driver.findElement(By.tagName("a")).click();


        //Exit the iframe and return to the main page
        driver.switchTo().defaultContent();
    }
}
