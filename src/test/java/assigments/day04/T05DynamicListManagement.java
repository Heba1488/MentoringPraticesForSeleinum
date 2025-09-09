package assigments.day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class T05DynamicListManagement {
      /*
    Task:  //Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:

            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */

    WebDriver driver;
    String url = "http://webdriveruniversity.com/To-Do-List/index.html";
    By inputText = By.xpath("//input[@type='text']");
    Faker faker =new Faker();
    @Test
    void T05DynamicListManagement() {
        // //Go to "http://webdriveruniversity.com/To-Do-List/index.html"
       driver.get(url);
       // Uses Faker to generate 5 random task names
      WebElement inputToDoList =driver.findElement(inputText);
        for (int i = 0; i < 5; i++) {
          inputToDoList.sendKeys(faker.job().title());
          inputToDoList.sendKeys(Keys.ENTER);

        }
          //Adds all tasks to the todo list
        List<WebElement> tasksInput = driver.findElements(By.cssSelector("ul li"));
        for (int i = 0; i < tasksInput.size(); i++) {
            // Marks every other task as completed (strikethrough)
            if (i % 2 == 0) {
                tasksInput.get(i).click();
            }
        }
         //  Deletes all completed tasks
        List<WebElement> deleteInput = driver.findElements(By.cssSelector("li > span > i"));
        for (int i = 0; i < tasksInput.size(); i++) {
            if (tasksInput.get(i).getAttribute("class").contains("completed")) {
                deleteInput.get(i).click();
            }
        }
        //Verifies only incomplete tasks remain
        List<WebElement> verifiesList = driver.findElements(By.cssSelector("li > span > i"));
        for (int i = 0; i < verifiesList.size(); i++) {
            WebElement task = verifiesList.get(i);
            Assertions.assertFalse(task.getAttribute("class").contains("completed"),
                    "Task should not be completed: " + task.getText());
        }
    }
      @BeforeEach
      void setUp() {
          driver= new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.manage().window().maximize();
      }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
