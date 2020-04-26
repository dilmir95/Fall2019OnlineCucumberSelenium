package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CalendarEventSteps {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user clicks on create calendar event")
    public void user_clicks_on_create_calendar_event() {
       calendarEventsPage.clickCreateCalanderEvent();
    }
    @Then("user enters {string} as title and {string} as description and click save and close")
    public void user_enters_as_title_and_as_description_and_click_save_and_close(String string, String string2) {
        calendarEventsPage.createCalendarEvent(string,string2);
    }
    @Then("verify that title info is {string} and description info is {string}")
    public void verify_that_title_info_is_and_description_info_is(String title, String description) {
       Assert.assertEquals(calendarEventsPage.getInfoTitle(),title);
    }
    @Then("user enters new calendar event information:")
    public void user_enters_new_calendar_event_information(Map<String,String> dataTable) {
      calendarEventsPage.createCalendarEvent(dataTable.get("title"),dataTable.get("description"));

    }

    @Then("user verifies new calendar event was created")
    public void user_verifies_new_calendar_event_was_created(Map<String,String> dataTable) {
       Assert.assertEquals(calendarEventsPage.getInfoTitle(),dataTable.get("title"));
    }

}
