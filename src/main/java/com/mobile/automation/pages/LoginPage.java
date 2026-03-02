package com.mobile.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By menuButton = By.xpath("//android.view.ViewGroup[@content-desc='open menu']");
    private final By loginMenuItem = By.xpath("//android.view.ViewGroup[@content-desc='menu item log in']");
    private final By usernameField = By.xpath("//android.widget.EditText[@content-desc='Username input field']");
    private final By passwordField = By.xpath("//android.widget.EditText[@content-desc='Password input field']");
    private final By loginButton = By.xpath("//android.view.ViewGroup[@content-desc='Login button']");
    private final By errorMessage = By.xpath("//android.view.ViewGroup[@content-desc='generic-error-message']");

    // Actions

    public void openLoginScreen() {
        driver.findElement(menuButton).click();
        driver.findElement(loginMenuItem).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getAttribute("content-desc");
    }

    public void login(String username, String password) {
        openLoginScreen();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void loginAndVerify(String username, String password) {
        login(username, password);
        // Wait for products screen to fully load after valid login
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@content-desc='products screen']")));
    }
}