package com.epiceros.qa.cucumber.steps;

import com.epiceros.page.UserHomePage;
import com.epiceros.page.elements.SideMenuElements;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class SideMenuSteps {

    @Autowired
    private UserHomePage userHomePage;

    @When("I select {} option in side menu")
    public void selectSideMenuOption(SideMenuElements sideMenuElement) {
        userHomePage.getSideMenuForm().selectMenuOption(sideMenuElement);
    }
}
