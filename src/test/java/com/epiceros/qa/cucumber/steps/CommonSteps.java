package com.epiceros.qa.cucumber.steps;

import com.epiceros.page.UserHomePage;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonSteps {

    @Autowired
    private UserHomePage userHomePage;

    @Given("Reset active sessions")
    public void resetSession() {
        userHomePage.resetSession();
        userHomePage.logOutIfPossible();
    }
}
