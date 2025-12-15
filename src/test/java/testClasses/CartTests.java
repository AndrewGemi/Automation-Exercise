package testClasses;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Gender;

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

    @Test
    public void verifyProductQuantityInCart_TC13() {
        new HomePage(driver)
                .checkHomePageVisible()
                .closeAdIfPresent()
                .clickViewProductsButton(1)
                .verifyProductDetailPageVisible(1)
                .setProductQuantity("4")
                .clickAddToCartButtonFromDetailPage()
                .clickViewCartModalButton()
                .verifyProductQuantityInCart("4");
    }

    @Test
    public void RemoveProductsFromCart_TC16(){
        new HomePage(driver)
                .checkHomePageVisible()
                .closeAdIfPresent()
                .clickAddToCartButton(3)
                .clickContinueShoppingButton()
                .clickAddToCartButton(4)
                .clickViewCartModalButton()
                .verifyCartListVisible()
                .clickRemoveButton(2)
                .verifyProductRemovedFromCart(1);
    }


}
