package com.epiceros.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        DriverType driverType = DriverType.valueOf(DriverType.class,
                System.getProperty("driver.type", "chrome").toUpperCase());
        switch (driverType) {
            case EDGE:
                return new EdgeDriver();
            case SAFARI:
                return new SafariDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }
}
