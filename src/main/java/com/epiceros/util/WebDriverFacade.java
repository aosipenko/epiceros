package com.epiceros.util;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.List;

public class WebDriverFacade {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public WebDriverFacade(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    public void loadPage(String url) {
        driver.get(url);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    public boolean waitForUrlToBe(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    public void resetAll() {
        driver.manage().deleteAllCookies();
    }

    @SneakyThrows
    public void clearInput(By locator) {
        WebElement input = driver.findElement(locator);
        String value = input.getDomAttribute("value");
        if (value != null && value.length() > 0) {
            input.click();
            input.sendKeys(Keys.END);
            for (int i = 0; i < value.length(); i++) {
                input.sendKeys(Keys.BACK_SPACE);
                Thread.sleep(50);
            }
        }
    }

    @PreDestroy
    private void quitDriver() {
        driver.quit();
    }

}
