package assigments.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptUtils;
import utilities.TestBase;

public class JavaScriptEventsTesting extends TestBase {
    /*
 Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
 Click all the buttons and verify they are all clicked
 */

    @Test
    public void eventsTestingWithJs() {
        // Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        //JS Code
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //find the Element
        WebElement onBlur = driver.findElement(By.id("onblur"));
        WebElement onClick = driver.findElement(By.id("onclick"));
        WebElement onContextMenu = driver.findElement(By.id("oncontextmenu"));
        WebElement onDoubleClick = driver.findElement(By.id("ondoubleclick"));
        WebElement onFocus = driver.findElement(By.id("onfocus"));
        WebElement onKeyDown = driver.findElement(By.id("onkeydown"));
        WebElement onKeyUp = driver.findElement(By.id("onkeyup"));
        WebElement onKeyPress = driver.findElement(By.id("onkeypress"));
        WebElement onMouseOver = driver.findElement(By.id("onmouseover"));
        WebElement onMouseLeave = driver.findElement(By.id("onmouseleave"));
        WebElement onMouseDown = driver.findElement(By.id("onmousedown"));


        WebElement onBlurMseege = driver.findElement(By.id("onblurstatus"));
        WebElement onClickMseege = driver.findElement(By.id("onclickstatus"));
        WebElement onContextMenuMseege = driver.findElement(By.id("oncontextmenustatus"));
        WebElement onDoubleClickMseege = driver.findElement(By.id("ondoubleclickstatus"));
        WebElement onFocusMseege = driver.findElement(By.id("onfocusstatus"));
        WebElement onKeyDownMseege = driver.findElement(By.id("onkeydownstatus"));
        WebElement onKeyUpMseege = driver.findElement(By.id("onkeyupstatus"));
        WebElement onKeyPressMseege = driver.findElement(By.id("onkeypressstatus"));
        WebElement onMouseOverMseege = driver.findElement(By.id("onmouseoverstatus"));
        WebElement onMouseLeaveMseege = driver.findElement(By.id("onmouseleavestatus"));
        WebElement onMouseDownMseege = driver.findElement(By.id("onmousedownstatus"));


        // Click the clickME button on the page.
        WebElement[] allButtons = {onBlur, onClick, onContextMenu, onDoubleClick, onFocus,
                onKeyDown, onKeyUp, onKeyPress, onMouseOver, onMouseLeave, onMouseDown};

        for (WebElement button : allButtons) {
            JavaScriptUtils.scrollToElement(driver, button);
            JavaScriptUtils.clickElement(driver, button);
        }

        //verify they are all clicked
        WebElement[] allMessages = {onBlurMseege, onClickMseege, onContextMenuMseege, onDoubleClickMseege, onFocusMseege,
                onKeyDownMseege, onKeyUpMseege, onKeyPressMseege, onMouseOverMseege, onMouseLeaveMseege, onMouseDownMseege};

        for (WebElement msg : allMessages) {
            String text = msg.getText();
            Assertions.assertTrue(text.contains("Event Triggered"));


        }
    }
}
