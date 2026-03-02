package com.mobile.automation.tests;

import com.mobile.automation.base.BaseTest;
import com.mobile.automation.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAndVerify("bob@example.com", "10203040");

        String productTitle = driver.findElement(
                By.xpath("//android.view.ViewGroup[@content-desc='products screen']")
        ).getAttribute("content-desc");

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
}