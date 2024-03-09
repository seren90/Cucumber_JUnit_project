package com.cydeo.step_definitons;

import com.cydeo.pages.R_DatatablePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class R_Datatable_StepDef {

    R_DatatablePage datatablePage = new R_DatatablePage();

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedModules) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        List<String> actualModules = new ArrayList<>();

        for (WebElement eachModule : datatablePage.allTopModules) {
            actualModules.add(eachModule.getText());
        }

        Assert.assertEquals(expectedModules,actualModules);

    }

}
