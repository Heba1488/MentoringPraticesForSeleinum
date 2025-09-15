package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Path;

public class T02FileUpload extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Upload a PDF using single upload button
Verify that 'Files uploaded successfully!'
Do negative test (No file or other than PDF)
Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
Test multiple PDFs as well
*/
    @Test
    public void testUploadSinglePDF() throws InterruptedException {
        //Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        //Upload a PDF using single upload button
       Path uploadSinglePDF = Path.of(System.getProperty("user.home"),"Downloads","08 - Selenium Files & .pdf");
       driver.findElement(By.className("upload-btn")).click();
       driver.findElement(By.id("uploadInput")).sendKeys(uploadSinglePDF.toString());
       driver.findElement(By.className("submit-btn")).click();
       WebElement successMseage = driver.findElement(By.id("successBox"));
       //Verify that 'Files uploaded successfully!'
        Thread.sleep(1000);
        Assertions.assertTrue(successMseage.isDisplayed());

    }
    @Test
    public void negativeUploadSinglePDF() throws InterruptedException {
        //Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        //Upload a PDF using single upload button
        Path uploadSinglePDF = Path.of(System.getProperty("user.home"),"Downloads","0- Selenium Files & .pdf");
        try{
            driver.findElement(By.id("uploadInput")).sendKeys(uploadSinglePDF.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        driver.findElement(By.className("upload-btn")).click();

        driver.findElement(By.className("submit-btn")).click();
        WebElement successMseage = driver.findElement(By.id("alertBox"));
        //Verify that 'Files uploaded successfully!'
        Thread.sleep(1000);
        Assertions.assertTrue(successMseage.isDisplayed());

    }


    @Test
    public void UploadMutiplePDF() throws InterruptedException {
        //Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        //Upload a PDF usin mutiple upload button
        Path uploadFile_1 = Path.of(System.getProperty("user.home"),"Downloads","08 - Selenium Files & .pdf");
        Path uploadFile_2 = Path.of(System.getProperty("user.home"),"Downloads","07-Selenium WebDriver - JS .pdf");

        driver.findElement(By.id("multiUploadInput")).sendKeys(uploadFile_1.toString());
        driver.findElement(By.id("multiUploadInput")).sendKeys(uploadFile_2.toString());
        driver.findElement(By.className("upload-btn")).click();

        driver.findElement(By.className("submit-btn")).click();
        WebElement successMseage = driver.findElement(By.id("successBox"));
        //Verify that 'Files uploaded successfully!'
        Thread.sleep(1000);
        Assertions.assertTrue(successMseage.isDisplayed());

    }
}
