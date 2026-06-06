package stepDefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import utils.WaitUtils;

public class RegisterSteps {

    WebDriver driver;
    HomePage homePage;
    WaitUtils waitUtils;
    
    RegisterPage registerPage;


    @Given("User is on Home page and clicks on My Account")
    public void user_is_on_home_page_and_clicks_on_my_account() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        waitUtils = new WaitUtils(driver);

        homePage.clickOnMyAccountOption();

    }

    @Then("User click on Register option")
    public void user_click_on_register_option() {
        homePage.clickOnRegisterOption();
    }

    @Then("User is on Register Page. Page title should be {string}")
    public void user_is_on_register_page_page_title_should_be(String expectedTitle) {
        String actualTitle = waitUtils.waitForTitleAndGet(expectedTitle);

        Assert.assertEquals("Titles not match", expectedTitle, actualTitle);
    }

    @Then("User enters First Name as {string} Last Name as {string} Email as {string} Telephone as {string} Password as {string} Password Confirm as {string}")
    public void user_enters_first_name_as_last_name_as_email_as_telephone_as_password_as_password_confirm_as(String firstname, String lastname, String email, String telephone, String password, String passwordConfirm) {
        registerPage.doRegister(firstname, lastname, email, telephone, password, passwordConfirm);
    }

    @Then("User select Newsletter Confirm as {string} and accept the Privacy Policy and click on Continue button")
    public void user_select_newsletter_confirm_as_and_accept_the_privacy_policy_and_click_on_continue_button(String newsletter) {
        registerPage.selectNewsLetterAndAcceptPrivacyPolicy(newsletter);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = waitUtils.waitForTitleAndGet(expectedTitle);

        Assert.assertEquals("Title mismatch", expectedTitle, actualTitle);
    }

}




