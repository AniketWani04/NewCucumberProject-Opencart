package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    JavascriptExecutor js;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }

    public void waitForElementToBeVisibleAndClick(By xpath) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

        try {
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click()", element);
        }
    }

    public void waitForElementToBeClickableAndClick(By xpath) {
        element = wait.until(ExpectedConditions.elementToBeClickable(xpath));

        try {
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click()", element);
        }
    }

    public String waitForTitleAndGet(String expectedTitle) {
        try {
            wait.until(ExpectedConditions.titleContains(expectedTitle));
        } catch (Exception e) {
            System.out.println("Title did not match within timeout");
        }
        String actualTitle = driver.getTitle();
        return actualTitle;
    }
}
