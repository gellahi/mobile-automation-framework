package com.mobile.automation.tests;

import com.mobile.automation.base.BaseTest;
import com.mobile.automation.pages.LoginPage;
import com.mobile.automation.pages.ProductsPage;
import com.mobile.automation.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductCartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAndVerify("bob@example.com", "10203040");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsScreenDisplayed(),
                "Products screen not displayed after login");

        productsPage.addFirstProductToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartScreenDisplayed(),
                "Cart screen not displayed");

        Assert.assertTrue(cartPage.isItemPresentInCart(),
                "Product was not added to cart");
    }

    @Test
    public void verifyCartNavigationTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAndVerify("bob@example.com", "10203040");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartScreenDisplayed(),
                "Cart navigation failed");
    }
}