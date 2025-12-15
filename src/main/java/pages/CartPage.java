package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ElementAction;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final WebDriver driver;
    private final By footer = By.id("footer");
    private final By cartList = By.cssSelector("tbody tr");
    private final By itemPrice = By.cssSelector("td.cart_price");
    private final By itemQuantity = By.cssSelector("td.cart_quantity");
    private final By itemTotal = By.cssSelector("td.cart_total");
    private final By quantitySectionInCart = By.cssSelector(".cart_quantity button");
    private final By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private final By RegisterLoginModal = By.xpath("//p[contains(text(),'Register / Login account to proceed on checkout.')]");
    private final By RegisterLoginButton = By.xpath("//u[contains(text(),'Register / Login')]");
    private final By removeButton = By.cssSelector(".cart_quantity_delete");

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
    public CartPage clickProceedToCheckoutButtonNotRegistered() {
        ElementAction.findElement(driver, proceedToCheckoutButton).click();
        return this;
    }

    public CartPage verifyRegisterLoginPageVisible() {
        Assert.assertTrue(ElementAction.findElement(driver, RegisterLoginModal).isDisplayed(), "Register/Login modal is not visible");
        return this;
    }
    public SignUpLoginPage clickRegisterLoginButton() {
        ElementAction.findElement(driver, RegisterLoginButton).click();
        return new SignUpLoginPage(driver);
    }
    public CheckoutPage clickProceedToCheckoutButtonRegistered() {
        ElementAction.findElement(driver, proceedToCheckoutButton).click();
        return new CheckoutPage(driver);
    }
    public CartPage clickRemoveButton(int index) {
        List<WebElement> removeButtons;
        removeButtons = ElementAction.findElements(driver, removeButton);
        removeButtons.get(index-1).click();
        return this;
    }

    public void verifyProductRemovedFromCart(int sizeExpected) {
        // add a wait of 2 seconds to allow the cart to update not thread
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(2));
        wait.until(driver -> {
            List<WebElement> cartItems = ElementAction.findElements(driver, cartList);
            return cartItems.size() == sizeExpected;
        });
        List<WebElement> cartItems = ElementAction.findElements(driver, cartList);
        Assert.assertEquals(cartItems.size(), sizeExpected, "Product was not removed from cart");
    }


}
