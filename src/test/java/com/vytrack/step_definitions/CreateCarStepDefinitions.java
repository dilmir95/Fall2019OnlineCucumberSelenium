package com.vytrack.step_definitions;

import com.vytrack.pages.fleet.VehiclesPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefinitions {
        VehiclesPage vehiclesPage = new VehiclesPage();

    @Then("user click on create car button")
    public void user_click_on_create_car_button() {
       vehiclesPage.clickCreateCar();
    }

    @Then("user creates a car with following info:")
    public void user_creates_a_car_with_following_info(List<Map<String, String>> data) {
        for (Map<String,String> eachRow: data){
            vehiclesPage.setLicencePlateInput(eachRow.get("License Plate"));
            vehiclesPage.setDriverInput(eachRow.get("Driver"));
            vehiclesPage.setLocationInput(eachRow.get("Location"));
            vehiclesPage.setModelYear(eachRow.get("Model Year"));
            vehiclesPage.setColor(eachRow.get("Color"));
            vehiclesPage.clickSaveAndClose();
        }

    }
    @Then("user verifies that car info is displayed:")
    public void user_verifies_that_car_info_is_displayed(List<Map<String ,String>> dataTable) {

        for (Map<String , String> eachRow: dataTable){
            Assert.assertEquals(eachRow.get("License Plate"),vehiclesPage.verifyValueCreateCar("License Plate"));
            Assert.assertEquals(eachRow.get("Driver"),vehiclesPage.verifyValueCreateCar("Driver"));
            Assert.assertEquals(eachRow.get("Location"),vehiclesPage.verifyValueCreateCar("Location"));
            Assert.assertEquals(eachRow.get("Model Year"),vehiclesPage.verifyValueCreateCar("Model Year"));
            Assert.assertEquals(eachRow.get("Color"),vehiclesPage.verifyValueCreateCar("Color"));


        }

    }
}
