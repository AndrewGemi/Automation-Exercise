package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementAction;

public class FooterPage {
    private final WebDriver driver;
    private final By subscriptionHeading = By.cssSelector(".single-widget h2");
    private final By subscriptionEmailInput = By.id("susbscribe_email");
    private final By subscriptionButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.cssSelector("#success-subscribe div");

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public FooterPage verifySubscriptionHeadingVisible() {
        ElementAction.findElement(driver, subscriptionHeading).isDisplayed();
        return this;
    }

    public FooterPage enterSubscriptionEmail(String email) {
        ElementAction.findElement(driver, subscriptionEmailInput).sendKeys(email);
        return this;
    }

    public FooterPage clickSubscriptionButton() {
        ElementAction.findElement(driver, subscriptionButton).click();
        return this;
    }

    public void verifySubscriptionSuccessMessageVisible() {
        ElementAction.findElement(driver, subscriptionSuccessMessage).isDisplayed();
    }
}
