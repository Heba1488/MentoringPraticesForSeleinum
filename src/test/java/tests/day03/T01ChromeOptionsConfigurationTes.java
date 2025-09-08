package tests.day03;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T01ChromeOptionsConfigurationTes
{
    /*
    Task: Create a test method that opens a browser with the following configurations:
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars Navigate to "https://www.example.com" and verify the title contains "Example"
     */
  static WebDriver driver;
    @BeforeEach
    public void setUp()
    {

      ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
    }
    @Test
    public void testOpenExampleWebsite() throws InterruptedException {
        driver.get("https://www.example.com");
        Thread.sleep(5000);

        //
        String title = driver.getTitle();
        assertTrue(title.contains("Example"), "Title should contain 'Example'");
        Thread.sleep(5000);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }




}
