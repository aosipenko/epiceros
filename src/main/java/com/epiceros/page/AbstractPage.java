package com.epiceros.page;

import com.epiceros.util.WebDriverFacade;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPage {

    @Autowired
    protected WebDriverFacade driverFacade;
    protected final String url;

    protected AbstractPage(String url) {
        this.url = url;
    }

    public void loadPage() {
        driverFacade.loadPage("about::blank");
        driverFacade.loadPage(url);
    }

    public boolean isLoaded() {
        return driverFacade.waitForUrlToBe(url);
    }

    public void resetSession() {
        driverFacade.resetAll();
    }
}
