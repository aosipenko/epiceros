package com.epiceros.qa.cucumber.steps;

import com.epiceros.page.UserHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class UserHomePageSteps {

    @Autowired
    private UserHomePage userHomePage;

    @Then("User Home Page is loaded")
    public void confirmPageLoaded() {
        Assert.assertTrue(userHomePage.isLoaded(), "User Home Page did not load on time");
    }

    @When("I close history modal")
    public void closeHistoryModal() {
        userHomePage.closeHistoryModal();
    }

    @When("I open side menu")
    public void openSideMenu() {
        userHomePage.openSideMenu();
    }
}
