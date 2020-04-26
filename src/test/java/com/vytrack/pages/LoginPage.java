package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement loginBtn;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotYourPassword;

    @FindBy(css = "*[class='alert alert-error']")
    private WebElement warningMsg;





    /**
     * login as specific user
     * @param username
     * @param password
     */
    public void login(String username , String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password,Keys.ENTER);

    }

    /**
     * login as store manager
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }
    public String getWarningMsgText(){
        return warningMsg.getText();
    }

    public void login(String loginAs){
        switch (loginAs){
            case "driver":
                login("user15","UserUser123");
                break;
            case "sales manager":
                login("salesmanager110","UserUser123");
                break;
            case "store manager":
                login();
                break;
            default: throw new RuntimeException();

        }
    }

}
