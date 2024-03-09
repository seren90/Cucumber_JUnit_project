package com.cydeo.step_definitons;

import com.cydeo.pages.R_VytrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class R_VytrackLogin_StepDef {

    R_VytrackLoginPage vytrackLoginPage = new R_VytrackLoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }

    @When("user enters the driver information")
    public void user_enters_the_driver_information() {
        /*vytrackLoginPage.username.sendKeys(ConfigurationReader.getProperty("driver_username"));
        vytrackLoginPage.password.sendKeys(ConfigurationReader.getProperty("driver_password"));
        vytrackLoginPage.loginButton.click();*/

        vytrackLoginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title verification failed!", expectedTitle,actualTitle);
    }

    @When("user enters the sales manager information")
    public void userEntersTheSalesManagerInformation() {
       vytrackLoginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("sales_manager_password"));
    }

    @When("user enters the store manager information")
    public void userEntersTheStoreManagerInformation() {
        vytrackLoginPage.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));
    }

    @When("user enters the {string} information")
    public void userEntersTheInformation(String userType) {
        vytrackLoginPage.dynamicLogin(userType);
    }

    @When("the user login with {string},{string}")
    public void theUserLoginWith(String username, String password) {
        vytrackLoginPage.login(username,password);
    }

    @Then("the user should not be able to log in")
    public void theUserShouldNotBeAbleToLogIn() {
        BrowserUtils.verifyTitle("Login");
    }
}
