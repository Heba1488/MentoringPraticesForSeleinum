package assigments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Test02 extends TestBase {
    /*
Go to https://claruswaysda.github.io/submit-button.html
Click on submit
Verify link contains 'actionsClickDrag'
Drag 'Drag me' to 'Drop here'
Right-click on 'Right-click' me  //showSuccessButton
Double-click on 'Double-click me'
Hover on 'Hover over me'
Verify all actions' success messages.
*/
     String url = "https://claruswaysda.github.io/submit-button.html";
    @Test
    public void Test01()
    {
        //Go to https://claruswaysda.github.io/submit-button.html
       driver.get(url);
        String mainWindow = driver.getWindowHandle();
       driver.findElement(By.xpath("//button[@id='submitButton']")).click();

        //switch window
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        //Verify link contains 'actionsClickDrag'
        Assertions.assertTrue(driver.getCurrentUrl().contains("actionsClickDrag"));
        //Drag 'Drag me' to 'Drop here'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dragMe = driver.findElement(By.id("drag1"));
        WebElement dropHere = driver.findElement(By.id("drop1"));  //dragSuccessMessage

        Actions action = new Actions(driver);
        action.dragAndDrop(dragMe, dropHere).perform();

        //Right-click on 'Right-click' me
        WebElement rightClickMe = driver.findElement(By.id("showSuccessButton"));  //rightClickSuccessMessage
        action.contextClick(rightClickMe).perform();
        //Double-click on 'Double-click me'
        WebElement doubleClick = driver.findElement(By.id("doubleClickButton"));//doubleClickSuccessMessage
         action.doubleClick(doubleClick).perform();
       // Hover on 'Hover over
        WebElement hoverOn = driver.findElement(By.id("hoverButton"));//hoverSuccessMessage
        action.moveToElement(hoverOn).perform();

        //Verify all actions' success messages.
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));

          WebElement dragAndDropMesseg = driver.findElement(By.id("dragSuccessMessage"));
          Assertions.assertTrue(dragAndDropMesseg.isDisplayed());

          WebElement rightClickMeMessage = driver.findElement(By.id("rightClickSuccessMessage"));
          Assertions.assertTrue(rightClickMeMessage.isDisplayed());

          WebElement doubleClickMessage = driver.findElement(By.id("doubleClickSuccessMessage"));
          Assertions.assertTrue(doubleClickMessage.isDisplayed());

          WebElement hoverOnMessage = driver.findElement(By.id("hoverSuccessMessage"));
          Assertions.assertTrue(hoverOnMessage.isDisplayed());



    }
}
