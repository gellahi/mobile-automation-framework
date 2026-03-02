package com.mobile.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private final AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By productsScreen = By.xpath("//android.view.ViewGroup[@content-desc='products screen']");
    private final By firstProduct = By.xpath("(//android.view.ViewGroup[@content-desc='store item'])[1]");
    private final By addToCartButton = By.xpath("//android.view.ViewGroup[@content-desc='Add To Cart button']");
    private final By cartIcon = By.xpath("//android.view.ViewGroup[@content-desc='cart badge']");
    private final By sortButton = By.xpath("//android.view.ViewGroup[@content-desc='sort button']");

    // Actions

    public boolean isProductsScreenDisplayed() {
        return driver.findElement(productsScreen).isDisplayed();
    }

    public void addFirstProductToCart() {
        driver.findElement(firstProduct).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(productsScreen));
    }

    public void openCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        // Wait until cart screen loads
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@content-desc='cart screen']")));
    }

    public void openSortOptions() {
        driver.findElement(sortButton).click();
    }
}