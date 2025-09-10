package assigments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test03 extends TestBase {
    /*
Go to https://claruswaysda.github.io/dragAndDrop.html
Drag the items in their right places
Assert the success message
*/

    @Test
    public void Test03()
    {
        // Go to https://claruswaysda.github.io/dragAndDrop.html
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");

        // find the items
        WebElement source1 = driver.findElement(By.id("piece1"));
        WebElement target1 = driver.findElement(By.id("slot1"));

        WebElement source2 = driver.findElement(By.id("piece2"));
        WebElement target2 = driver.findElement(By.id("slot2"));


        WebElement source3 = driver.findElement(By.id("piece3"));
        WebElement target3 = driver.findElement(By.id("slot3"));
        // use the actions
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source1, target1).perform();
        actions.dragAndDrop(source2, target2).perform();
        actions.dragAndDrop(source3, target3).perform();

     // Assert the success message
        WebElement successMessage = driver.findElement(By.id("celebrate"));
        Assertions.assertEquals("Congratulations!", successMessage.getText());

    }
    }

