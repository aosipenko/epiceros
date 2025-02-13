package com.epiceros.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserProfilePage extends AbstractPage {

    private final static String URL = "https://wunderino:rhinodev@stage.wunderino.de/de/account/profile";
    private final static String PROFILE_FIELD_NAMES_XPATH = "//dl/dt";
    private final static String PROFILE_FIELD_VALUES_XPATH = "//dl/dd";

    protected UserProfilePage() {
        super(URL);
    }

    public Map<String, String> assembleUserProfile() {
        List<WebElement> keys = driverFacade.getElements(By.xpath(PROFILE_FIELD_NAMES_XPATH));
        List<WebElement> values = driverFacade.getElements(By.xpath(PROFILE_FIELD_VALUES_XPATH));
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            result.put(keys.get(i).getText().toUpperCase(), values.get(i).getText().toUpperCase());
        }
        return result;
    }

    @Override
    public boolean isLoaded() {
        driverFacade.waitForUrlToBe(url);
        driverFacade.waitForElementToBeVisible(By.xpath("//select[@name='language']"));
        return true;
    }
}
