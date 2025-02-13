package com.epiceros.page.elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum UserHomePageElements {

    GO_HOME_BTN(LocatorHelper.attrActionXpath("confirmGoHome")),
    OPEN_MENU(LocatorHelper.attrActionXpath("openMenu")),
    LOYALTY_ICON(By.className("UserLoyaltyLevel-content"));

    @Getter
    private final By locator;

    UserHomePageElements(org.openqa.selenium.By locator) {
        this.locator = locator;
    }
}
