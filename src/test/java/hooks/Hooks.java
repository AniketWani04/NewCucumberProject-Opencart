package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import driver.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Hooks {
WebDriver driver;

    @Before
    public void setup() {
        DriverFactory.initDriver();
    }

    @After(order = 1)
    public void takesScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
        driver = DriverFactory.getDriver();
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
                String timestamp = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

                String scenarioName = scenario.getName().replaceAll(" ", "_");
                String path = System.getProperty("user.dir") + "/screenshots/";

                File destFile = new File(path + scenarioName + "_" + timestamp + ".png");
                FileUtils.copyFile(srcFile, destFile);


                String base64 = Base64.getEncoder().encodeToString(screenshot);

                // ✅ IMPORTANT FORMAT FOR EXTENT
                String base64Image = "data:image/png;base64," + base64;

                scenario.attach(base64Image.getBytes(), "image/png", scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        DriverFactory.quitDriver();
    }

    /*@After(order = 2)
    public void tearDown() {
        DriverFactory.quitDriver();
    }*/
}
