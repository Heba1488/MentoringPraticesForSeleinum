package assigments.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotWithNavigation  extends TestBase {
    /*
     * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
     * Click into the username field.
     * Type the username using sendKeys.
     * Use the Robot class to:
     * Press Tab → go to password field.
     * Type the password using sendKeys.
     * Press Enter → submit the form.
     * Verify login success or error message.
     */

    @Test
    public void T01() throws AWTException {
        // Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
       driver.get("https://the-internet.herokuapp.com/login");
       By username = By.id("username");
       By password = By.id("password");
       //Click into the username field.
       driver.findElement(username).click();
       //Type the username using sendKeys.
       driver.findElement(username).sendKeys("tomsmith");
       //Use the Robot class to:
       Robot robot = new Robot();
       // Press Tab → go to password field.
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(2000);
        //Type the password using sendKeys
        driver.findElement(password).sendKeys("SuperSecretPassword!");
        //Press Enter → submit the form
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        //Verify login success or error message.
        String message = driver.findElement(By.id("flash")).getText();
        Assertions.assertTrue(message.contains("You logged into a secure area!"));




    }

}
