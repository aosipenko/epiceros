package com.epiceros.page;

import com.epiceros.page.form.LoginForm;
import com.epiceros.page.form.RegistrationForm;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.epiceros.page.elements.LoginPageElements.*;

@Component
public class LoginPage extends AbstractPage {
    private final static String URL = "https://wunderino:rhinodev@stage.wunderino.de/de/";

    @Autowired
    @Getter
    private LoginForm loginForm;

    @Autowired
    @Getter
    private RegistrationForm registrationForm;

    public LoginPage() {
        super(URL);
    }

    public LoginForm initLogin() {
        driverFacade.waitForElementToBeVisible(LOGIN_BTN.getLocator()).click();
        driverFacade.waitForElementToBeVisible(LOGIN_FORM.getLocator());
        return loginForm;
    }

    public RegistrationForm initRegistration() {
        driverFacade.waitForElementToBeVisible(REGISTRATION_BTN.getLocator()).click();
        driverFacade.waitForElementToBeVisible(REGISTRATION_FORM.getLocator());
        return registrationForm;
    }
}
