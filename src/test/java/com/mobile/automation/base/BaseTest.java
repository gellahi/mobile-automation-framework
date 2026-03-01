package com.mobile.automation.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Device");
        options.setUdid("bqor7p75pnprw8jz");
        options.setApp(System.getProperty("user.dir") + "/app/sauce-demo.apk");
        options.setAutoGrantPermissions(true);
        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}