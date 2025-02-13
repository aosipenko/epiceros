package com.epiceros.qa.cucumber.steps;

import com.epiceros.page.LoginPage;
import com.epiceros.page.elements.RegistrationFormElements;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class RegistrationStepsForm {
    @Autowired
    private LoginPage loginPage;

    @Then("I can see {} element in Registration Form")
    public void validateRegistrationForm(RegistrationFormElements element) {
        Assert.assertTrue(loginPage.getRegistrationForm().isElementVisible(element),
                "Registration form element missing: " + element.name());
    }
}
