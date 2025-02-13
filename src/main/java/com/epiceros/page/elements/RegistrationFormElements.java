package com.epiceros.page.elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum RegistrationFormElements {

    REGISTRATION_HEADER(LocatorHelper.attrNameXpath("registrationForm"));

    @Getter
    private final By locator;

    RegistrationFormElements(By locator) {
        this.locator = locator;
    }
}
