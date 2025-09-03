package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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
    //**** Poisiotion******
    Point position = driver.manage().window().getPosition();
    System.out.println("position.getX() = " + position.getX());
    System.out.println("position.getY() = " + position.getY());
    System.out.println("position = " + position);
    ///****size******
    Dimension dimension = driver.manage().window().getSize();
    System.out.println("dimension.getWidth() = " + dimension.getWidth());
    System.out.println("dimension.getHeight() = " + dimension.getHeight());
    System.out.println("dimension = " + dimension);

// Adjust the position and size of the page as desired. 
    driver.manage().window().setPosition(new org.openqa.selenium.Point(position.getX()+50, position.getY()-20));
    driver.manage().window().setSize(new org.openqa.selenium.Dimension(600, 600));
// Test that the page is in the position and size you want. // Close the page.
    //driver.close();
    driver.quit();
}
}
