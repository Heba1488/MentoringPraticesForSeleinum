package assigments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task04
{
    /*
    *open URL: https://www.google.com
    * Maximize the window
    * print the positon and size of the page
    * Minimize the page
    * wait 5 seconds in the icon state and maximize the page
    * print the position and dimensions of the page in maximized state
    * make the page fullscreen
    * close the browser
    *
     */
    public static void main(String[] args) throws InterruptedException {
        // create WebDriver
        WebDriver driver = new FirefoxDriver();
        // get open URL: https://www.google.com
        driver.navigate().to("https://www.google.com");
        //Maximize the window
        driver.manage().window().maximize();
        //print the positon and size of the page
        System.out.println("Size :" + driver.manage().window().getSize());
        System.out.println("Position : " + driver.manage().window().getPosition());
        //Minimize the page
        driver.manage().window().minimize();
       // wait 5 seconds in the icon state and maximize the page
        Thread.sleep(5000);
        driver.manage().window().maximize();
        // print the position and dimensions of the page in maximized state
        System.out.println("Size :" + driver.manage().window().getSize());
        System.out.println("Position : " + driver.manage().window().getPosition());
        //make the page fullscreen
        driver.manage().window().fullscreen();
        //close the browser
        driver.close();
        driver.quit();
    }
}
