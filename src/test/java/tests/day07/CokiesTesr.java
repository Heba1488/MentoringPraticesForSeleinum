package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.Set;

public class CokiesTesr extends TestBase {
    /*
Go to https://claruswaysda.github.io/CookiesWait.html
Accept the alert if it is present
Print the cookies
Delete all cookies and assert
*/

    @Test
    public void cokiesTest() throws AWTException {
        driver.get("https://claruswaysda.github.io/CookiesWait.html");
        WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println(" No Alart");
        }

     /*   driver.findElement(By.id("acceptCookiesButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("delayedButton")).click();*/
        //Print the cookies
        Set<Cookie> cookieSet = driver.manage().getCookies();
        cookieSet.forEach(System.out::println);
        //Delete all cookies and assert
        driver.manage().deleteAllCookies();
        Set<Cookie> cookiesEmpty = driver.manage().getCookies();
        cookieSet.forEach(System.out::println);
        Assertions.assertTrue(cookiesEmpty.isEmpty());

    }
}
