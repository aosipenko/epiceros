package com.epiceros.page.form;


import com.epiceros.page.elements.RegistrationFormElements;
import com.epiceros.util.WebDriverFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationForm {

    @Autowired
    private WebDriverFacade driverFacade;

    public boolean isElementVisible(RegistrationFormElements element) {
        return driverFacade.waitForElementToBeVisible(element.getLocator()).isDisplayed();
    }

    public void closeForm() {

    }
}
