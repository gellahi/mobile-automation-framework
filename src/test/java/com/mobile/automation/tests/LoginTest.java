package com.mobile.automation.tests;

import com.mobile.automation.base.BaseTest;
import com.mobile.automation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAndVerify("bob@example.com", "10203040");

        String productTitle = driver.findElement(
                By.xpath("//android.view.ViewGroup[@content-desc='products screen']")).getAttribute("content-desc");

        Assert.assertTrue(productTitle.contains("products"),
                "User was not redirected to Products screen");
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid@example.com", "wrongpass");

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(error.length() > 0,
                "Error message was not displayed for invalid login");
    }

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAndVerify("bob@example.com", "10203040");

        driver.findElement(
                By.xpath("//android.view.ViewGroup[@content-desc='open menu']")).click();

        driver.findElement(
                By.xpath("//android.view.ViewGroup[@content-desc='menu item log out']")).click();

        // Confirm logout on the "Are you sure?" popup
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.id("android:id/button1"))).click();

        // Dismiss "Successfully logged out" dialog
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.id("android:id/button1"))).click();

        // Verify: open menu and check "Log In" option is back (not "Log Out")
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@content-desc='open menu']"))).click();

        boolean loginOptionVisible = driver.findElement(
                By.xpath("//*[@content-desc='menu item log in']")).isDisplayed();

        Assert.assertTrue(loginOptionVisible, "Logout failed");
    }
}