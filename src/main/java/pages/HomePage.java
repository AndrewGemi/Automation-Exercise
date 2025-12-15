package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ElementAction;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final By slider = By.id("slider");
    private final By signupLogin = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By loggedInAsUsername = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By deleteAccountButton = By.xpath("//a[.=' Delete Account']");
    private final By accountDeletedHeading = By.xpath("//b[.='Account Deleted!']");
    private final By logOutButton = By.xpath("//a[contains(text(),'Logout')]");
    private final By contactUsButton = By.xpath("//a[.=' Contact us']");
    private final By testCasesButton = By.xpath("//a[.=' Test Cases']");
    private final By footerSection = By.id("footer");
    private final By cartButton = By.xpath("//a[@href='/view_cart']");
    private final By shadowRootHost = By.className("grippy-host");
    private final By productsButton = By.xpath("//a[contains(text(),'Products')]");
    private final By headercartButton = By.xpath("//a[contains(text(),' Cart')]");
    private final By productsList = By.cssSelector(".features_items div.product-image-wrapper");
    private final By viewCartButtonLocator = By.xpath("//u[contains(text(),'View Cart')]");
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private final By continueShoppingButton = By.cssSelector("div.modal-footer button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // homepage is visible
    public HomePage checkHomePageVisible() {
//        System.out.println(driver);
        Assert.assertTrue(ElementAction.findElement(driver, slider).isDisplayed(), "Home page is not visible");
        System.out.println("Home page is visible successfully");
        return this;
    }

    public SignUpLoginPage clickSignupLogin() {
        ElementAction.findElement(driver, signupLogin).click();
        return new SignUpLoginPage(driver);
    }

    public HomePage verifyLoggedInAsUsernameVisible() {
        ElementAction.findElement(driver, loggedInAsUsername).isDisplayed();
        return this;
    }

    public HomePage clickDeleteAccountButton() {
        ElementAction.findElement(driver, deleteAccountButton).click();
        return this;
    }

    public HomePage verifyAccountDeletedVisible() {
        ElementAction.findElement(driver, accountDeletedHeading).isDisplayed();
        System.out.println("Account deleted successfully");
        return this;
    }

    public SignUpLoginPage clickLogOutButton() {
        ElementAction.findElement(driver, logOutButton).click();
        return new SignUpLoginPage(driver);
    }

    public ContactUsPage clickContactUsButton() {
        ElementAction.findElement(driver, contactUsButton).click();
        return new ContactUsPage(driver);
    }

    public void clickTestCasesButton() {
        ElementAction.findElement(driver, testCasesButton).click();

    }

    public ProductsPage clickProductsButton() {
        ElementAction.findElement(driver, productsButton).click();
        return new ProductsPage(driver);
    }

    public CartPage navigateToCartPage() {
        ElementAction.findElement(driver, cartButton).click();
        return new CartPage(driver);
    }

    public FooterPage scrollToFooterSection() {
        ElementAction.scrollToElement(driver, footerSection);
        return new FooterPage(driver);
    }

    public ProductsPage clickViewProductsButton(int productNum) {
        ElementAction.findElement(driver, By.xpath("//a[@href='/product_details/"+ productNum +"']")).click();
        return new ProductsPage(driver);
    }

    public HomePage closeAdIfPresent() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(shadowRootHost));
        } catch (TimeoutException ignored) {
            return this; // Element never showed up → move on
        }

        // If we're here, element was found
        WebElement element = driver.findElement(shadowRootHost);
        if (element.isDisplayed()) {
            element.click();
        }
        SearchContext shadowRoot = ElementAction.findElement(driver, shadowRootHost).getShadowRoot();
        By arrowAdCloseButton = By.cssSelector(".ee span");
        WebElement adCloseButton = shadowRoot.findElement(arrowAdCloseButton);
        if (adCloseButton.isDisplayed()) {
            adCloseButton.click();
        }
        return this;
    }

    public HomePage hoverOverProduct(int productNum) {
        By productLocator = By.xpath("(//div[@class='product-image-wrapper'])[" + productNum + "]");
        // move to product before hovering
        ElementAction.scrollToElement(driver,productLocator);
        ElementAction.hoverOverElement(driver, ElementAction.findElement(driver, productLocator));
        return this;
    }

    public HomePage clickAddToCartButton(int productIndex) {
        ElementAction.scrollToElement(driver,By.xpath("//a[@data-product-id='"+productIndex+"']"));
       ElementAction.findElement(driver,By.xpath("//a[@data-product-id='"+productIndex+"']")).click();
       return this;
    }

    public CartPage clickViewCartModalButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButtonLocator));
        ElementAction.findElement(driver, viewCartButtonLocator).click();
        return new CartPage(driver);
    }

    public CartPage clickHeaderCartButton() {
        ElementAction.findElement(driver, headercartButton).click();
        return new CartPage(driver);
    }

    public HomePage clickContinueButton() {
        ElementAction.findElement(driver, continueButton).click();
        return this;
    }

    public HomePage clickContinueShoppingButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        ElementAction.findElement(driver, continueShoppingButton).click();

        return this;
    }



}
