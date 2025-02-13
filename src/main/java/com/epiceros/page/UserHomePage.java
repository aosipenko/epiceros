package com.epiceros.page;

import com.epiceros.page.form.SideMenuForm;
import lombok.Getter;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.epiceros.page.elements.UserHomePageElements.*;

@Component
public class UserHomePage extends AbstractPage {

    private final static String URL = "https://wunderino:rhinodev@stage.wunderino.de/de/";

    @Autowired
    @Getter
    private SideMenuForm sideMenuForm;

    public UserHomePage() {
        super(URL);
    }

    public UserHomePage closeHistoryModal() {
        driverFacade.waitForElementToBeClickable(GO_HOME_BTN.getLocator()).click();
        driverFacade.waitForElementToDisappear(GO_HOME_BTN.getLocator());
        return this;
    }

    public SideMenuForm openSideMenu() {
        driverFacade.waitForElementToBeVisible(OPEN_MENU.getLocator()).click();
        return sideMenuForm;
    }

    public void logOutIfPossible() {
        List<WebElement> loyaltyIcon = driverFacade.getElements(LOYALTY_ICON.getLocator());
        if (!loyaltyIcon.isEmpty()) {
            try {
                openSideMenu().logOut();
            } catch (ElementClickInterceptedException clickInterceptedException) {
                System.out.println("Click intercepted, cannot log out!");
            }
        }
    }
}
