package com.mobile.automation.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Device");
        options.setUdid("bqor7p75pnprw8jz");
        options.setAutoGrantPermissions(true);
        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
        options.setNoReset(true);
        options.setCapability("appium:skipDeviceInitialization", true);
        options.setCapability("appium:ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void resetAppState() {
        driver.terminateApp("com.saucelabs.mydemoapp.rn");
        driver.executeScript("mobile: clearApp", Map.of("appId", "com.saucelabs.mydemoapp.rn"));
        driver.activateApp("com.saucelabs.mydemoapp.rn");
        // Wait for React Native app to fully cold-start
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@content-desc='open menu']")));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}