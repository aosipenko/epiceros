package com.epiceros.page.elements;

import org.openqa.selenium.By;

public class LocatorHelper {
    private final static String ATTRIBUTE_NAME = "//*[@data-ph-capture-attribute-name='%s']";
    private final static String ATTRIBUTE_ACTION = "//*[@data-ph-capture-attribute-action='%s']";

    public static By attrNameXpath(String attribute) {
        return By.xpath(String.format(ATTRIBUTE_NAME, attribute));
    }

    public static By attrActionXpath(String attribute) {
        return By.xpath(String.format(ATTRIBUTE_ACTION, attribute));
    }
}
