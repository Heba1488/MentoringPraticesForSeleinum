package tests.day08;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class T01FileDownLoadTest extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Click on download
Verify that 'QAProgram.png' file is downloaded
*/
    @Test
    public void Test01FileDownLoadTest() throws InterruptedException, IOException {
        //Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");
        //Click on download
        driver.findElement(By.className("download-btn")).click();
        Thread.sleep(2000);
        //Verify that 'QAProgram.png' file is downloaded

        String downloadPath = System.getProperty("user.home") + "/Downloads/QAProgram.png";
        File downloadedFile = new File(downloadPath);
        Assertions.assertTrue(downloadedFile.exists());
    }
}
