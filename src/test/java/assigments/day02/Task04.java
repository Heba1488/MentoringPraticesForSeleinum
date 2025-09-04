package assigments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {
    /*
    Task 4: Multiple Navigation and Verification
Setup:
Launch Chrome and maximize in @BeforeEach.
Test 1:
Navigate Google → YouTube → LinkedIn.
Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
Test 2:
Navigate back twice and assert the URL of Google.
Navigate forward twice and assert URL of LinkedIn.
Teardown:
Use @AfterEach to quit the browser.
     */

    WebDriver driver;
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("The Teastin is execu....");
    }

    @Test
    public void task01(){
        driver.navigate().to("https://www.google.com");
        String googleTitle = driver.getTitle();
        Assertions.assertTrue(googleTitle.contains("Google"));
        driver.navigate().to("https://www.youtube.com");
        String youtubeTitle = driver.getTitle();
        Assertions.assertTrue(youtubeTitle.contains("YouTube"));
        driver.navigate().to("https://www.linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assertions.assertTrue(linkedinTitle.contains("LinkedIn"));
    }


    @Test
    public void task02(){
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://www.youtube.com");
        driver.navigate().to("https://www.linkedin.com");

        driver.navigate().back();
        driver.navigate().back();
         String checkGoogleUrl =driver.getCurrentUrl();
        Assertions.assertTrue(checkGoogleUrl.toLowerCase().contains("google"));
        driver.navigate().forward();
        driver.navigate().forward();
        String checkLinkedinUrl =driver.getCurrentUrl();
        Assertions.assertTrue(checkLinkedinUrl.toLowerCase().contains("linkedin"));
    }
    @AfterEach
    public void teardown(){
            driver.quit();
    }

}
