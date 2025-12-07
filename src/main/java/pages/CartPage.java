package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementAction;

public class CartPage {
    private final WebDriver driver;
    private final By footer = By.id("footer");
    private final By cartList = By.cssSelector("tbody tr");
    private final By itemPrice = By.cssSelector("td.cart_price");
    private final By itemQuantity = By.cssSelector("td.cart_quantity");
    private final By itemTotal = By.cssSelector("td.cart_total");

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

}
