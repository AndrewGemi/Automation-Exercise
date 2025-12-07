package testClasses;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends BaseTests {

    @Test
    public void verifySubscriptionInHomePage_TC10() {
        new HomePage(driver)
                .checkHomePageVisible()
                .scrollToFooterSection()
                .verifySubscriptionHeadingVisible()
                .enterSubscriptionEmail("ss@gmail.com")
                .clickSubscriptionButton()
                .verifySubscriptionSuccessMessageVisible();
    }
}
