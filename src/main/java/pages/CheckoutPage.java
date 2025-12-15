package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementAction;

public class CheckoutPage {
    private final WebDriver driver;
    private final By textAreaComments = By.className("form-control");
    private final By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
    private final By NameOnCardInput = By.xpath("//input[@data-qa='name-on-card']");
    private final By CardNumberInput = By.xpath("//input[@data-qa='card-number']");
    private final By CVCInput = By.xpath("//input[@data-qa='cvc']");
    private final By ExpirationMonthInput = By.xpath("//input[@data-qa='expiry-month']");
    private final By ExpirationYearInput = By.xpath("//input[@data-qa='expiry-year']");
    private final By payAndConfirmOrderButton = By.xpath("//button[@data-qa='pay-button']");
    private final By orderConfirmationMessage = By.xpath("//p[contains(text(),'Your order has been placed successfully!')]");
    private final By orderPlacedHeading = By.xpath("//b[contains(text(),'Order Placed!')]");
    private final By continueShoppingButton = By.xpath("//a[@data-qa='continue-button']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage addComments(String comments) {
        driver.findElement(textAreaComments).sendKeys(comments);
        return this;
    }
    public CheckoutPage clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
        return this;
    }
    public CheckoutPage enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        driver.findElement(NameOnCardInput).sendKeys(nameOnCard);
        driver.findElement(CardNumberInput).sendKeys(cardNumber);
        driver.findElement(CVCInput).sendKeys(cvc);
        driver.findElement(ExpirationMonthInput).sendKeys(expiryMonth);
        driver.findElement(ExpirationYearInput).sendKeys(expiryYear);
        return this;
    }
    public CheckoutPage clickPayAndConfirmOrderButton() {
        driver.findElement(payAndConfirmOrderButton).click();
        return this;
    }
    public CheckoutPage verifyOrderConfirmationMessageVisible() {
        if (!ElementAction.findElements(driver, orderConfirmationMessage).isEmpty() || !ElementAction.findElements(driver, orderPlacedHeading).isEmpty()) {
            System.out.println("Order has been placed successfully!");
        } else {
            Assert.fail("Order confirmation message is not visible");
        }
        return this;
    }
    public HomePage clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
        return new HomePage(driver);
    }



}
