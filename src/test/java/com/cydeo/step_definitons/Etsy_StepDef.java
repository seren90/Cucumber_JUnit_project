package com.cydeo.step_definitons;

import com.cydeo.pages.EtsyHomePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_StepDef {

    EtsyHomePage etsyHomePage = new EtsyHomePage();

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        Driver.getDriver().get("https://www.etsy.com");
    }
    @Then("user should see title is as expected")
    public void user_should_see_title_is_as_expected() {

        String expectedTitle = "Etsy Germany - Shop for handmade, vintage, custom, and unique gifts for everyone";
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("User types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {
        etsyHomePage.searchBox.sendKeys("Wooden Spoon");
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        etsyHomePage.popup.click();
        etsyHomePage.searchButton.click();
    }

    @Then("User sees Wooden Spoon is in the title")
    public void userSeesWoodenSpoonIsInTheTitle() {

        BrowserUtils.verifyTitle("Wooden spoon - Etsy DE");
    }

    @When("User types {string} in the search box")
    public void userTypesInTheSearchBox(String keyWord) {
        etsyHomePage.searchBox.sendKeys(keyWord);
    }

    @Then("User sees {string} is in the title")
    public void userSeesIsInTheTitle(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }
}
