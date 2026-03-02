package com.mobile.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private final AndroidDriver driver;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By checkoutScreen = By.xpath("//*[@content-desc='checkout address screen']");
    private final By fullNameField = By.xpath("//android.widget.EditText[@content-desc='Full Name* input field']");
    private final By addressField = By.xpath("//android.widget.EditText[@content-desc='Address Line 1* input field']");
    private final By cityField = By.xpath("//android.widget.EditText[@content-desc='City* input field']");
    private final By zipField = By.xpath("//android.widget.EditText[@content-desc='Zip Code* input field']");
    private final By countryField = By.xpath("//android.widget.EditText[@content-desc='Country* input field']");
    private final By paymentButton = By.xpath("//android.view.ViewGroup[@content-desc='To Payment button']");
    private final By errorMessage = By.xpath("//*[contains(@content-desc, '-error-message')]");

    // Actions

    public boolean isCheckoutScreenDisplayed() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.presenceOfElementLocated(checkoutScreen)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void fillCheckoutForm(String name, String address, String city,
                                 String zip, String country) {

        driver.findElement(fullNameField).clear();
        driver.findElement(fullNameField).sendKeys(name);
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipField).clear();
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(countryField).clear();
        driver.findElement(countryField).sendKeys(country);
    }

    public void proceedToPayment() {
        driver.findElement(paymentButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getAttribute("content-desc");
    }
}