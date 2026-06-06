package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {

    WebDriver driver;
    WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    private By myAccountOption = By.xpath("//li[contains(@class, 'dropdown')]//a[contains(., 'My Account')]");
    private By registerOption = By.xpath("//a[contains(text(), 'Register')]");
    private By loginOption = By.xpath("//a[contains(text(), 'Login')]");

    public void clickOnMyAccountOption() {
        waitUtils.waitForElementToBeVisibleAndClick(myAccountOption);
    }

    public void clickOnRegisterOption() {
        waitUtils.waitForElementToBeVisibleAndClick(registerOption);
    }

}
