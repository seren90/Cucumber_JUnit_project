package com.cydeo.step_definitons;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
We will be able to create "pre" and "post" condition for ALL of the SCENARIOS and even steps
 */
public class Hooks {

    //import the @Before coming from io.cucumber.java
    @Before (order = 1)
    public void setupMethod(){
        System.out.println("--> @Before: RUNNING BEFORE EACH SCENARIO");
    }

   // @Before (value = "@login", order = 2) --> bir test senaryosunda birden fazla @Before işlemi varsa, bu işlemlerin sıralamasını belirlemek amacıyla order özelliği kullanılabilir.
    public void login_scenario_before(){
        System.out.println("--> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    //@After will be executed automatically after EVERY scenario in the project.
    @After
    public void teardownMethod(Scenario scenario){

        String str="";

        if (scenario.isFailed()){

        byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

    }

        BrowserUtils.sleep(2);
        System.out.println("--> @After: RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver();
    }

   // @BeforeStep
    public void setupStep(){
        System.out.println("----> @BeforeStep: RUNNING BEFORE EACH STEP!");
    }

   // @AfterStep
    public void teardownStep(){
        System.out.println("----> @AfterStep: RUNNING AFTER EACH STEP!");

    }

}
