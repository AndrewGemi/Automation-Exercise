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

    @Test
    public void viewCategoryProducts_TC18() {
        new HomePage(driver)
                .selectCategory("Women")
                .closeAdIfPresent()
                .selectSubCategory("Tops")
                .verifyCategoryProductsVisible("WOMEN - TOPS PRODUCTS")
                .selectCategory("Men")
                .selectSubCategory("Jeans")
                .verifyCategoryProductsVisible("MEN - JEANS PRODUCTS");

    }
}
