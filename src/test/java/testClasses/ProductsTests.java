package testClasses;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductsTests extends BaseTests {

    @Test
    public void Verify_All_Products_and_product_detail_page_TC8() {
        new HomePage(driver)
                .checkHomePageVisible()
                .clickProductsButton()
                .verifyURlContainsProducts()
                .verifyProductListVisible()
                .closeAdIfPresent()
                .clickFirstProductViewDetails()
                .verifyProductDetailPageVisible()
                .verifyProductDetails();

    }

    @Test
    public void Search_Product_TC9() {
        String productName = "T-Shirt";
        new HomePage(driver)
                .checkHomePageVisible()
                .clickProductsButton()
                .verifyURlContainsProducts()
                .verifyProductListVisible()
                .closeAdIfPresent()
                .enterProductNameInSearchInput(productName)
                .clickSearchButton()
                .verifyProductListVisible()
                .verifyAllProductsRelatedToSearch(productName);
    }
}
