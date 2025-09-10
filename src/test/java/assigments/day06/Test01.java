package assigments.day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Test01  extends TestBase {
        /*
Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
1. Maximize the website
2. Click on the second emoji
3. Click on all second emoji items
4. Return to the parent iframe
5. Fill out the form and press the apply button
*/


    String url ="https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/";

    @Test
    void test01() {
        driver.navigate().to(url);
        WebElement emojis = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(emojis);
        // Click on the second emoji
        driver.findElement(By.xpath("//a[@href='#nature']")).click();
        //Click on all second emoji items
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> allSecondEmojis = driver.findElements(By.cssSelector("#nature img"));
        for (WebElement emoji : allSecondEmojis) {
            emoji.click();
        }
        //Return to the parent iframe
        driver.switchTo().defaultContent();
        //Fill out the form and press the apply button
        driver.findElement(By.id("text")).sendKeys("Hello");
        driver.findElement(By.id("food")).sendKeys("Pizza");
        driver.findElement(By.id("activities")).sendKeys("Football");
        driver.findElement(By.id("places")).sendKeys("Paris");
        driver.findElement(By.id("objects")).sendKeys("Laptop");

        driver.findElement(By.id("send")).click();

    }
}
