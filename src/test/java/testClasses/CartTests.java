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

    @Test
    public void AddProductToCart_TC12() {
        new HomePage(driver)
                .checkHomePageVisible()
                .clickProductsButton()
                .closeAdIfPresent()
                .hoverOverProduct(1)
                .clickAddToCartButton(1)
                .clickContinueShoppingButton()
                .hoverOverProduct(2)
                .clickAddToCartButton(2)
                .clickViewCartModalButton()
                .verifyCartListVisible()
                .verifyItemPriceQuantityTotalVisible();
    }
}
