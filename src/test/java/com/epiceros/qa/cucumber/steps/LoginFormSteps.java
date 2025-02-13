package com.epiceros.qa.cucumber.steps;

import com.epiceros.page.LoginPage;
import com.epiceros.page.elements.ElementState;
import com.epiceros.page.elements.LoginFormElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LoginFormSteps {

    @Autowired
    private LoginPage loginPage;

    @Given("I set username to {string}")
    public void setLoginUsername(String value) {
        loginPage.getLoginForm().setUserName(value);
    }

    @Given("I set password to {string}")
    public void setLoginPassword(String value) {
        loginPage.getLoginForm().setPassword(value);
    }

    @Then("I can see {} element in Login Form")
    public void validateLoginFormElement(LoginFormElements element) {
        loginPage.getLoginForm().isElementVisible(element);
    }

    @Then("I can see {} element is {} in Login Form")
    public void validateLoginFormElement(LoginFormElements element, ElementState elementState) {
        String message = "Login form element " + element.name() + " should be " + elementState.name();
        if (ElementState.ENABLED.equals(elementState)) {
            Assert.assertTrue(loginPage.getLoginForm().isElementEnabled(element), message);
        } else {
            Assert.assertFalse(loginPage.getLoginForm().isElementEnabled(element), message);
        }
    }

    @When("I press {} element in Login Form")
    public void pressElement(LoginFormElements element) {
        loginPage.getLoginForm().clickFormElement(element);
    }

    @Then("Password value is {string} and equal to {string}")
    public void validateFieldValue(String state, String expectedValue) {
        switch (state) {
            case "masked":
                Assert.assertEquals(
                        loginPage.getLoginForm().getFieldValue(LoginFormElements.PASSWORD),
                        expectedValue,
                        "Password value mismatch!");
                Assert.assertEquals(
                        loginPage.getLoginForm().getFieldType(LoginFormElements.PASSWORD),
                        "password",
                        "Password value mismatch!"
                );
                break;
            case "not masked":
                Assert.assertEquals(
                        loginPage.getLoginForm().getFieldValue(LoginFormElements.PASSWORD),
                        expectedValue,
                        "Password value/type mismatch!");
                Assert.assertNotEquals(
                        loginPage.getLoginForm().getFieldType(LoginFormElements.PASSWORD),
                        "password",
                        "Password value/type mismatch!"
                );
                break;
            default:
                Assert.fail("Unknown password field state");
        }
    }
}
