package tests.day08;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class C42TakeScreenShot01 extends TestBase {
    /*
    Go to Google
    Take full page screenshot
    Take a specific element's screenshot
*/

    @Test
    public void screenShotTest() throws IOException, InterruptedException {
        //       Go to Clarusway
        driver.get("https://opensource-demo.orangehrmlive.com/");
     Thread.sleep(1000);
        //       Take full page screenshot
        TakesScreenshot ss = (TakesScreenshot) driver;
        File screenshot = ss.getScreenshotAs(OutputType.FILE);
        Path path = Path.of(System.getProperty("user.dir"),"screenshot","lastScreenshot.png");
        FileUtils.copyFile(screenshot, path.toFile());
        //FileUtils.copyFile(screenShot,new File("./target/test-output/googleSs.png"));

        //       Take a specific element's screenshot
    }
}
