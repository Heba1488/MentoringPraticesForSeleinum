package assigments.day01;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Task02 {
    /*
    *invoke FireFox Driver
    * go to https://www.youtub.com
    * verify the page title contains the word video
    * close driver
     */
    public static void main(String[] args) throws InterruptedException {
        //invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();
        //go to https://www.youtub.com
        driver.get("https://www.youtube.com");
       // verify the page title contains the word video
        String titleOfPage = driver.getTitle();
        System.out.println("titleOfPage = " + titleOfPage);
        if(titleOfPage.contains("video")){
            System.out.println("Page Title Is Correct");
        }
        else{
            System.out.println("Page Title Is Not Correct");
        }
        //close driver
        driver.close();
    }
}
