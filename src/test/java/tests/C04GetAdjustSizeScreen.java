package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04GetAdjustSizeScreen
{
    // TC - 04

    // Go to the w3school URL : https://www.w3schools.com/ 
// Print the position and size of the page. 
// Adjust the position and size of the page as desired. 
// Test that the page is in the position and size you want. // Close the page.
public static void main(String[] args) throws InterruptedException
{
    // TC - 04

// Go to the w3school URL : https://www.w3schools.com/ 
    WebDriver driver=new ChromeDriver();
    driver.navigate().to("https://www.w3schools.com");
// Print the position and size of the page. 
    System.out.println(driver.manage().window().getPosition());
    System.out.println(driver.manage().window().getSize());
// Adjust the position and size of the page as desired. 

// Test that the page is in the position and size you want. // Close the page.
}
}
