package assigments.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tssk03 {
    /*
    *Go to amazon URL: https://www.amazon.com
    * Print the position and size of page
    * Adjust the position and size of the page as desired
    * Test that the page is in the position and size you want
    * close page
     */
    public static void main(String[] args) {
        // create Webdriver
        WebDriver driver = new FirefoxDriver();
        //Go to amazon URL: https://www.amazon.com
        driver.navigate().to("https://www.amazon.com");
        //Print the position and size of page
        Point expectedPosition = new Point(80, 10);
        Dimension expectedSize = new Dimension(600, 600);
        driver.manage().window().setPosition(expectedPosition);
        driver.manage().window().setSize(expectedSize);
        System.out.println("expectedSize = " + expectedSize);
        System.out.println("expectedPosition = " + expectedPosition);
        //Adjust the position and size of the page as desired
        Point actualPosition = driver.manage().window().getPosition();
        Dimension actualSize = driver.manage().window().getSize();
        // Test that the page is in the position and size you want
        // Test Position
        if(actualPosition.equals(expectedPosition)){
            System.out.println("Position is correct: " + actualPosition );
        }else{
            System.out.println("Position mismatch: "+expectedPosition);
        }
        //Test Size

        if(actualSize.equals(expectedSize)){
            System.out.println("Size is correct: " + actualSize);
        }else{
            System.out.println("Size mismatch: "+expectedSize );
        }


       // close page
        driver.close();
    }
}
