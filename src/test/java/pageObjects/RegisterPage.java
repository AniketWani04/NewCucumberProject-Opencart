package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class RegisterPage {

    WebDriver driver;
    WaitUtils waitUtils;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    private By firstNameInput = By.xpath("//input[@name = 'firstname']");
    private By lastNameInput = By.xpath("//input[@name = 'lastname']");
    private By emailInput = By.xpath("//input[@name = 'email']");
    private By telephoneInput = By.xpath("//input[@name = 'telephone']");
    private By passwordInput = By.xpath("//input[@name = 'password']");
    private By passwordConfirmInput = By.xpath("//input[@name = 'confirm']");
    private By newsLetterYesOption = By.xpath("//label[contains(., 'Yes')]//input");
    private By privacyPolicyOption = By.xpath("//input[@type = 'checkbox']");
    private By continueButton = By.xpath("//input[@type = 'submit']");

    public void doRegister(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {

        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(telephoneInput).sendKeys(telephone);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(passwordConfirmInput).sendKeys(passwordConfirm);
    }

    public void selectNewsLetterAndAcceptPrivacyPolicy(String newsletter) {

        if(newsletter.equalsIgnoreCase("yes")) {
            waitUtils.waitForElementToBeClickableAndClick(newsLetterYesOption);
        }
        waitUtils.waitForElementToBeClickableAndClick(privacyPolicyOption);
        waitUtils.waitForElementToBeClickableAndClick(continueButton);
    }
}
