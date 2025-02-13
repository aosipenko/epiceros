package com.epiceros.page.elements;

import lombok.Getter;
import org.openqa.selenium.By;

import static com.epiceros.page.elements.LocatorHelper.attrActionXpath;
import static com.epiceros.page.elements.LocatorHelper.attrNameXpath;

public enum LoginFormElements {
    LOGIN_ERROR(By.xpath("//p[@data-testid='loginError']")),
    FORM(attrNameXpath("loginButton")),
    FORGOT_PASSWORD(attrActionXpath("gotoForgotPassword")),
    REGISTER_USER(attrActionXpath("gotoSignUp")),
    LOGIN_BUTTON(attrActionXpath("login")),
    BACK_TO_LOGIN(By.xpath("//div[text()='Abbrechen']")),
    SHOW_PASSWORD(By.xpath("//input[@name='password']/../../div[2]")),
    USERNAME(By.name("username")),
    PASSWORD(By.name("password"));

    @Getter
    private final By locator;

    LoginFormElements(By locator) {
        this.locator = locator;
    }
}
