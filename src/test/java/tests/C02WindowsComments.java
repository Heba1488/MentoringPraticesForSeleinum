package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02WindowsComments {
    public static void main(String[] args) throws InterruptedException {
        // TC - 02

// Go to www.yahoo.com 
// Maximize Window 
// Go to www.amazon.com 
// Maximize Window 
// Navigate Back
// Navigate Forward
// Refresh The Page

        WebDriver driver = new ChromeDriver();

        // Go to www.yahoo.com 
        driver.navigate().to("https://www.linkedIn.com");
// Maximize Window 
        driver.manage().window().maximize();
        Thread.sleep(1000);
// Go to www.amazon.com 
        driver.navigate().to("https://www.amazon.com");
// Maximize Window 
        driver.manage().window().minimize();
        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
// Navigate Back
     driver.navigate().back();
        Thread.sleep(1000);
// Navigate Forward
        driver.navigate().forward();
        Thread.sleep(1000);
// Refresh The Page
        driver.navigate().refresh();
        Thread.sleep(1000);

        driver.quit();
    }
}


// TC – 03

// Expected Title 
// Set Path of the Chrome driver 
// Launch Chrome browser 
// Open URL of Website 
// Maximize Window 
// Get Title of current Page 
// Validate/Compare Page Title 
// Close Browser



// TC - 04

// Go to the w3school URL : https://www.w3schools.com/ 
// Print the position and size of the page. 
// Adjust the position and size of the page as desired. 
// Test that the page is in the position and size you want. // Close the page.