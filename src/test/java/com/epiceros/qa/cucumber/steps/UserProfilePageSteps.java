package com.epiceros.qa.cucumber.steps;

import com.epiceros.page.UserProfilePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class UserProfilePageSteps {

    @Autowired
    private UserProfilePage userProfilePage;

    @Then("User Profile page is loaded")
    public void confirmPageLoaded() {
        Assert.assertTrue(userProfilePage.isLoaded());
    }

    @Then("User profile contains:")
    public void validateProfile(DataTable dataTable) {
        Map<String, String> userProfile = userProfilePage.assembleUserProfile();
        SoftAssert softAssert = new SoftAssert();
        dataTable.asMap().entrySet().stream().forEach(e -> {
            softAssert.assertTrue(userProfile.containsKey(e.getKey().toUpperCase()),
                    "No key present in user profile!" + e.getKey().toUpperCase());
            softAssert.assertEquals(userProfile.get(e.getKey().toUpperCase()), e.getValue().toUpperCase(),
                    "Value mismatch for key " + e.getKey().toUpperCase());
        });
        softAssert.assertAll();
    }
}
