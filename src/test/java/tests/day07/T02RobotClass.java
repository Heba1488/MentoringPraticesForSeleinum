package tests.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T02RobotClass extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Click on 'Upload'
Close the opening page using 'CTRL+F4'
*/

    @Test
    public void robotTest() throws AWTException {
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        WebElement upload = driver.findElement(By.xpath("//label[.//text()[normalize-space()='Upload']]"));
        upload.click();
        Robot robot = new Robot();
        robot.setAutoDelay(5);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.setAutoDelay(5);


    }
}
