package testClasses;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

public class CartTests extends BaseTests {

    @Test
    public void verifySubscriptionInCartPage_TC11() {
        new HomePage(driver)
                .checkHomePageVisible()
                .navigateToCartPage()
                .scrollToFooterSection()
                .verifySubscriptionHeadingVisible()
                .enterSubscriptionEmail("ss@gmail.com")
                .clickSubscriptionButton()
                .verifySubscriptionSuccessMessageVisible();
    }
}
