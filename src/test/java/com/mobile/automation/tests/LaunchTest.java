package com.mobile.automation.tests;

import com.mobile.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchTest extends BaseTest {

    @Test
    public void verifyAppLaunch() {

        String currentPackage = driver.getCurrentPackage();

        Assert.assertEquals(currentPackage,
                "com.saucelabs.mydemoapp.rn",
                "App did not launch correctly");
    }
}