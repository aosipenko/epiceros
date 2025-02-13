package com.epiceros.qa.cucumber.steps;

import com.epiceros.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageSteps {

    @Autowired
    private LoginPage loginPage;

    @Given("I load login page")
    public void loadPage() {
        loginPage.loadPage();
    }

    @When("I open login form")
    public void openLoginForm() {
        loginPage.initLogin();
    }
}
