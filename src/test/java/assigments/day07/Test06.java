package assigments.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Test06 extends TestBase {
    /*
    Go to https://claruswaysda.github.io/Dropdowns.html
    In 1. Traditional Dropdown select 'Ford'  //carSelect
    In 2. Multi-Select Dropdown select 'Mercedes'    //multiCarSelect
    In 3. Custom Dropdown (Bootstrap-like) select 'BMW'  //customDropdown
    In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'  //staticInput
   In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'    //dynamicInput
*/

    String url ="https://claruswaysda.github.io/Dropdowns.html";

    @Test
    void  test06() throws InterruptedException {
        driver.navigate().to(url);
        //1. Traditional Dropdown select 'Ford'
        WebElement traditionalDropdown  = driver.findElement(By.id("carSelect"));
        Select select1 = new Select(traditionalDropdown );
        select1.selectByVisibleText("Ford");
        Thread.sleep(1000);
        // In 2. Multi-Select Dropdown select 'Mercedes'
        WebElement multiSelectDropdown = driver.findElement(By.id("multiCarSelect"));
        Select select2 = new Select(multiSelectDropdown);
        select2.selectByVisibleText("Mercedes");
        Thread.sleep(1000);
        // In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
        WebElement customDropdown = driver.findElement(By.id("customDropdown"));
        customDropdown.click();
        WebElement bmwOption = driver.findElement(By.xpath("//*[@id='multiCarSelect']/option[2]"));
        bmwOption.click();
        Thread.sleep(1000);
       // In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
        WebElement staticAutoSuggestDropdown = driver.findElement(By.id("staticInput"));
        staticAutoSuggestDropdown.sendKeys("Tesla Model 3",Keys.ENTER);
        Thread.sleep(1000);
        // In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
        WebElement  dynamicAutoSuggestDropdown = driver.findElement(By.id("dynamicInput"));
        dynamicAutoSuggestDropdown.sendKeys("Toyota",Keys.ENTER);
        Thread.sleep(1000);
    }
}
