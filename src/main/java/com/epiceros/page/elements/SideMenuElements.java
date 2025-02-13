package com.epiceros.page.elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum SideMenuElements {
    ACCOUNT_PROFILE(LocatorHelper.attrNameXpath("/account/profile")),
    LOG_OUT(LocatorHelper.attrActionXpath("logout"));
    @Getter
    private final By locator;

    SideMenuElements(org.openqa.selenium.By locator) {
        this.locator = locator;
    }
}
