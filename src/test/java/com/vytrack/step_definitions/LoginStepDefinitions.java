package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
        LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa3"));

        System.out.println("open login page");


    }

    @When("user logs in as a sales manager")
    public void user_logs_in_as_a_sales_manager() {
        System.out.println("login as salesmanager");
        loginPage.login("salesmanager110","UserUser123");


    }

    @Then("user should verify that title is a Dashboard")
    public void user_should_verify_that_title_is_a_Dashboard() {
        BrowserUtils.wait(1);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        //
        Driver.closeDriver();
    }
    @When("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        loginPage.login();

    }

    @When("user logs in as driver")
    public void user_logs_in_as_driver() {
        loginPage.login("user15","UserUser123");
    }

    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        loginPage.login(string,string2);
    }

    @When("user navigates to {string} and {string}")
    public void user_navigates_to_and(String tab, String module) {
        loginPage.navigateTo(tab,module);
        BrowserUtils.wait(3);
    }

    @Then("user name should be {string}")
    public void user_name_should_be(String string) {
        Assert.assertEquals(loginPage.getCurrentUserName(),string);
    }
    @When("user logs in as {string}")
    public void user_logs_in_as(String string) {
        loginPage.login(string);
    }

    @Then("user verifies that page title is {string}")
    public void user_verifies_that_page_title_is(String string) {
        Assert.assertEquals(string,Driver.getDriver().getTitle());
    }



}
