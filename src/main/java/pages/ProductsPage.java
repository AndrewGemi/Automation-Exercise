package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ElementAction;

import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    private final By productsList = By.cssSelector(".features_items");
    private final By firstProduct = By.xpath("//a[@href='/product_details/1']");
    private final By productName = By.cssSelector(".product-information h2");
    private final By productCategory = By.xpath("//p[contains(text(),'Category:')]");
    private final By productPrice = By.cssSelector(".product-information span span");
    private final By productQuantity = By.xpath("//p //b[contains(text(),'Availability:')]");
    private final By productCondition = By.xpath("//p //b[contains(text(),'Condition:')]");
    private final By productBrand = By.xpath("//p //b[contains(text(),'Brand:')]");
    private final By shadowRootHost = By.className("grippy-host");
    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By searchedProductsList = By.cssSelector(".single-products>div>p");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductsPage verifyURlContainsProducts() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/products", "URL does not contain 'products'");
        return this;
    }

    public ProductsPage verifyProductListVisible() {
        Assert.assertTrue(ElementAction.findElement(driver, productsList).isDisplayed());
        return this;
    }

    public ProductsPage closeAdIfPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(shadowRootHost)
        );
        element.click();
        SearchContext shadowRoot = ElementAction.findElement(driver, shadowRootHost).getShadowRoot();
        By arrowAdCloseButton = By.cssSelector(".ee span");
        WebElement adCloseButton = shadowRoot.findElement(arrowAdCloseButton);
        if (adCloseButton.isDisplayed()) {
            adCloseButton.click();
        }
        return this;
    }

    public ProductsPage clickFirstProductViewDetails() {

        ElementAction.findElement(driver, firstProduct).click();
        return this;
    }

    public ProductsPage verifyProductDetailPageVisible() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1", "Product detail page is not visible");
        return this;
    }

    public void verifyProductDetails() {
        Assert.assertTrue(ElementAction.findElement(driver, productName).isDisplayed(), "Product name is not displayed");
        Assert.assertTrue(ElementAction.findElement(driver, productCategory).isDisplayed(), "Product category is not displayed");
        Assert.assertTrue(ElementAction.findElement(driver, productPrice).isDisplayed(), "Product price is not displayed");
        Assert.assertTrue(ElementAction.findElement(driver, productQuantity).isDisplayed(), "Product quantity is not displayed");
        Assert.assertTrue(ElementAction.findElement(driver, productCondition).isDisplayed(), "Product condition is not displayed");
        Assert.assertTrue(ElementAction.findElement(driver, productBrand).isDisplayed(), "Product brand is not displayed");
    }

    public ProductsPage enterProductNameInSearchInput(String productName) {
        ElementAction.findElement(driver, searchInput).sendKeys(productName);

        return this;
    }

    public ProductsPage clickSearchButton() {
        ElementAction.findElement(driver, searchButton).click();
        return this;
    }

    public void verifyAllProductsRelatedToSearch(String productName) {
        for (WebElement product : ElementAction.findElements(driver, searchedProductsList)) {
            Assert.assertTrue(product.getText().toLowerCase().contains(productName.toLowerCase()),
                    "Product " + product.getText() + " is not related to search term " + productName);
        }
    }
}
