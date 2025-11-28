package testClasses;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestCasesTests extends BaseTests {

    @Test
    public void TestCases_TC7() {
        new HomePage(driver)
                .checkHomePageVisible()
                .clickTestCasesButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/test_cases", "URL does not match expected test cases URL");

    }
}
