package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class R_VytrackLoginPage {

    public R_VytrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="prependedInput")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement loginButton;

    public void login(String userName, String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();
    }

    public void dynamicLogin(String userType){ // userType = sales manager
        userType = userType.replace(" ", "_"); // userType = "sales_manager"
        String username = ConfigurationReader.getProperty(userType + "_username"); // username = "sales_manager_username"
        String password = ConfigurationReader.getProperty(userType + "_password"); // password = "sales_manager_password"

        login(username,password);
    }


}
