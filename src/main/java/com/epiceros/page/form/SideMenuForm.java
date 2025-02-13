package com.epiceros.page.form;

import com.epiceros.page.elements.SideMenuElements;
import com.epiceros.util.WebDriverFacade;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.epiceros.page.elements.SideMenuElements.LOG_OUT;

@Component
public class SideMenuForm {

    @Autowired
    private WebDriverFacade driverFacade;

    public void selectMenuOption(SideMenuElements element) {
        driverFacade.waitForElementToBeVisible(element.getLocator()).click();
    }

    public void logOut() {
        driverFacade.waitForElementToBeClickable(LOG_OUT.getLocator()).sendKeys(Keys.ENTER);
    }
}
