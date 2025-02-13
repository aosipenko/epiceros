package com.epiceros.page.form;

import com.epiceros.page.elements.LoginFormElements;
import com.epiceros.util.WebDriverFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.epiceros.page.elements.LoginFormElements.*;

@Component
public class LoginForm {

    @Autowired
    private WebDriverFacade driverFacade;
    @Autowired
    private RegistrationForm registrationForm;

    public LoginForm setUserName(String userName) {
        driverFacade.clearInput(USERNAME.getLocator());
        driverFacade.waitForElementToBeVisible(USERNAME.getLocator()).sendKeys(userName);
        return this;
    }

    public LoginForm setPassword(String password) {
        driverFacade.clearInput(PASSWORD.getLocator());
        driverFacade.waitForElementToBeVisible(PASSWORD.getLocator()).sendKeys(password);
        return this;
    }

    public LoginForm forgotPassword() {
        driverFacade.waitForElementToBeVisible(FORGOT_PASSWORD.getLocator()).click();
        driverFacade.waitForElementToDisappear(FORGOT_PASSWORD.getLocator());
        driverFacade.waitForElementToBeVisible(BACK_TO_LOGIN.getLocator());
        driverFacade.waitForElementToBeVisible(USERNAME.getLocator());
        return this;
    }

    public LoginForm showPassword() {
        driverFacade.waitForElementToBeVisible(SHOW_PASSWORD.getLocator()).click();
        return this;
    }

    public RegistrationForm registerUser() {
        driverFacade.waitForElementToBeVisible(REGISTER_USER.getLocator()).click();
        return registrationForm;
    }

    public boolean isLoginAllowed() {
        return driverFacade.waitForElementToBeVisible(LOGIN_BUTTON.getLocator()).isEnabled();
    }

    public void closeForm() {

    }

    public boolean isElementVisible(LoginFormElements element) {
        return driverFacade.waitForElementToBeVisible(element.getLocator()).isDisplayed();
    }

    public boolean isElementEnabled(LoginFormElements element) {
        return driverFacade.getElement(element.getLocator()).isEnabled();
    }

    public void clickFormElement(LoginFormElements element) {
        driverFacade.getElement(element.getLocator()).click();
    }

    public String getFieldValue(LoginFormElements element) {
        return driverFacade.getElement(element.getLocator()).getDomAttribute("value");
    }

    public String getFieldType(LoginFormElements element) {
        return driverFacade.getElement(element.getLocator()).getDomAttribute("type");
    }
}
