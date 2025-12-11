package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementAction;

public class CartPage {
    private final WebDriver driver;
    private final By footer = By.id("footer");
    private final By cartList = By.cssSelector("tbody tr");
    private final By itemPrice = By.cssSelector("td.cart_price");
    private final By itemQuantity = By.cssSelector("td.cart_quantity");
    private final By itemTotal = By.cssSelector("td.cart_total");
    private final By quantitySectionInCart = By.cssSelector(".cart_quantity button");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public FooterPage scrollToFooterSection() {
        ElementAction.scrollToElement(driver, footer);
        return new FooterPage(driver);
    }

    public CartPage verifyCartListVisible() {
        ElementAction.findElements(driver, cartList).getFirst().isDisplayed();
        return this;
    }

    public void verifyItemPriceQuantityTotalVisible() {
        ElementAction.findElement(driver, itemPrice).isDisplayed();
        ElementAction.findElement(driver, itemQuantity).isDisplayed();
        ElementAction.findElement(driver, itemTotal).isDisplayed();
    }
    public void verifyProductQuantityInCart(String expectedQuantity) {
        String actualQuantity = ElementAction.findElement(driver, quantitySectionInCart).getText();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Product quantity in cart does not match expected quantity");
    }

}
