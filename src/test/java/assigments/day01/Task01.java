package assigments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {
    /*
    *creat main method
    * create chrome driver
    * open google home page :https:\\www.google.com
    * get title on page
    * get current page
    * close/quite browesr
    *
     */
    //*creat main method
    public static void main(String[] args) throws InterruptedException {
       //  * create chrome driver
       WebDriver driver=new ChromeDriver();
       //* open google home page :https://www.google.com
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        //* get title on page
       String titleOfPage = driver.getTitle();
        Thread.sleep(1000);
       //* get current page
       String  currentPage =driver.getCurrentUrl();
        Thread.sleep(1000);
       // close/quite browesr
        System.out.println("titleOfPage = " + titleOfPage);
        System.out.println("currentPage = " + currentPage);
        driver.close();
        Thread.sleep(1000);
        driver.quit();
    }
}
