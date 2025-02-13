package com.epiceros.page.elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum LoginPageElements {
    LOGIN_FORM(By.className("useMq")),
    REGISTRATION_FORM(By.xpath("//*[@data-ph-capture-attribute-name='registrationForm']")),
    LOGIN_BTN(By.xpath("//*[@data-ph-capture-attribute-name='loginButton']")),
    REGISTRATION_BTN(By.xpath("//*[@data-ph-capture-attribute-name='registrationButton']"));

    @Getter
    private final By locator;

    LoginPageElements(By locator) {
        this.locator = locator;
    }
}
