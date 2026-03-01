package com.mobile.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CartPage {

    private final AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By cartScreen = By.xpath("//android.view.ViewGroup[@content-desc='cart screen']");
    private final By checkoutButton = By.xpath("//android.view.ViewGroup[@content-desc='Proceed To Checkout button']");
    private final By cartItem = By.xpath("//android.view.ViewGroup[@content-desc='cart item']");

    // Actions

    public boolean isCartScreenDisplayed() {
        return driver.findElement(cartScreen).isDisplayed();
    }

    public boolean isItemPresentInCart() {
        return driver.findElements(cartItem).size() > 0;
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}