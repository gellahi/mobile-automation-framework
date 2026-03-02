package com.mobile.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By cartScreen = By.xpath("//*[@content-desc='cart screen']");
    private final By checkoutButton = By.xpath("//android.view.ViewGroup[@content-desc='Proceed To Checkout button']");
    private final By cartItem = By.xpath("//android.view.ViewGroup[@content-desc='product row']");

    // Actions

    public boolean isCartScreenDisplayed() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.presenceOfElementLocated(cartScreen)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isItemPresentInCart() {
        return driver.findElements(cartItem).size() > 0;
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}