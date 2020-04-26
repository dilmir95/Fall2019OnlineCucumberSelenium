package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,10);
    public PageBase(){
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "#user-menu>a")
    protected WebElement currentUserName;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    protected WebElement saveAndClose;

    public String getCurrentUserName(){
        return currentUserName.getText().trim();
    }


    /**
     *
     * @param tabName for example: Fleet, Costumers, Sales, Activities
     * @param moduleName for example: Vehicles, Accounts, Contacts, Vehicle Odometer
     */
    public void navigateTo(String tabName, String moduleName) {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        Actions actions = new Actions(driver);

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));
        BrowserUtils.wait(2);
        actions.moveToElement(tabElement).pause(1000).click(moduleElement).build().perform();



    }
}
