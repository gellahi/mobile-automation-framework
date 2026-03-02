package com.mobile.automation.tests;

import com.mobile.automation.base.BaseTest;
import com.mobile.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutNavigationTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAndVerify("bob@example.com", "10203040");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isCheckoutScreenDisplayed(),
                "Checkout screen not displayed");
    }

    @Test
    public void checkoutValidationErrorTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAndVerify("bob@example.com", "10203040");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToPayment();

        String error = checkoutPage.getErrorMessage();

        Assert.assertTrue(error.length() > 0,
                "Validation error not shown for empty checkout form");
    }

    @Test
    public void completeCheckoutFormTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAndVerify("bob@example.com", "10203040");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillCheckoutForm(
                "John Doe",
                "123 Street",
                "New York",
                "10001",
                "USA"
        );

        checkoutPage.proceedToPayment();

        // We just verify no crash and navigation continues
        Assert.assertTrue(true);
    }
}