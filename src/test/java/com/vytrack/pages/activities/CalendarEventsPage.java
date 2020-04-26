package com.vytrack.pages.activities;


import com.vytrack.pages.PageBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends PageBase {


    @FindBy(css = "*[title='Create Calendar event']")
    private WebElement createCalendarEventBtn;

    @FindBy(className = "select2-chosen")
    private WebElement ownerName;

    @FindBy(css = "*[id^='date_selector_oro_calendar_event_form_start-ui']")
    private WebElement startDate;

    @FindBy(css = "*[id^='time_selector_oro_calendar_event_form_start-uid']")
    private WebElement startTime;

    @FindBy(css = "*[id^='time_selector_oro_calendar_event_form_end-uid']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy (css = "*[id^='oro_calendar_event_form_title-uid']")
    private WebElement titleBox;

    @FindBy (xpath = "//iframe")
    private WebElement frame;

    @FindBy (id = "tinymce")
    private WebElement descriptionBox;



    @FindBy (xpath = "//div[@class='control-label'][1]")
    private WebElement generalInfoTitle;

    @FindBy (xpath = "//*[contains(text(),'View per page:')]/following-sibling::*//a")
    private List<WebElement> viewPerPageElement;

    @FindBy (css = "button[class='btn dropdown-toggle ']")
    private WebElement viewPerPageToggle;



    public List<String> getViewPerPageOptions(){
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(viewPerPageToggle));
        viewPerPageToggle.click();
        BrowserUtils.wait(2);
        return BrowserUtils.getTextFromWebElements(viewPerPageElement);

    }

    

    public void createCalendarEvent(String title , String description){
        BrowserUtils.wait(5);
        wait.until(ExpectedConditions.visibilityOf(titleBox));
        titleBox.sendKeys(title);
        //wait.until(ExpectedConditions.textToBePresentInElement(titleBox,title));
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        descriptionBox.sendKeys(description);
        driver.switchTo().defaultContent();
        saveAndClose.click();


    }
    public String getInfoTitle(){
        wait.until(ExpectedConditions.visibilityOf(generalInfoTitle));
       return generalInfoTitle.getText();
    }





    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(ownerName));
        return ownerName.getText().trim();
    }
    public void clickCreateCalanderEvent(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEventBtn)).click();


    }
    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(10);

        return startDate.getAttribute("value");
    }

    public String getStartTime(){
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTime(){
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }

    public List<String> getColumnNames(){
        BrowserUtils.waitForPageToLoad(10);
        return BrowserUtils.getTextFromWebElements(columnNames);

    }

}
