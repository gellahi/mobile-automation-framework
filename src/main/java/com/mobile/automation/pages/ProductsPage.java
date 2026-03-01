package com.mobile.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductsPage {

    private final AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By productsScreen = By.xpath("//android.view.ViewGroup[@content-desc='products screen']");
    private final By firstAddToCartButton = By.xpath("(//android.view.ViewGroup[@content-desc='Add To Cart button'])[1]");
    private final By cartIcon = By.xpath("//android.view.ViewGroup[@content-desc='cart badge']");
    private final By sortButton = By.xpath("//android.view.ViewGroup[@content-desc='sort button']");

    // Actions

    public boolean isProductsScreenDisplayed() {
        return driver.findElement(productsScreen).isDisplayed();
    }

    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void openSortOptions() {
        driver.findElement(sortButton).click();
    }
}