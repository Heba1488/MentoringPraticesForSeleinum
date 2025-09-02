package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03BrowserComments {
    // TC – 03

    // Expected Title
// Set Path of the Chrome driver
// Launch Chrome browser
// Open URL of Website
// Maximize Window
// Get Title of current Page
// Validate/Compare Page Title
// Close Browser
    public static void main(String[] args) throws InterruptedException {
        // TC – 03

// Expected Title
        String expTitle="Google";
// Set Path of the Chrome driver

        
// Launch Chrome browser
        WebDriver driver = new ChromeDriver();
// Open URL of Website
        driver.navigate().to("https://www.google.com");
// Maximize Window
        driver.manage().window().maximize();
// Get Title of current Page
       String actualTitle  = driver.getTitle();
       // System.out.println("actualTitle = " + actualTitle);
// Validate/Compare Page Title
        if(actualTitle.equals(expTitle)){
            System.out.println("Page Title Is Correct");
        }
        else{
            System.out.println("Page Title Is Not Correct");
        }
// Close Browser
        driver.quit();



    }
}
