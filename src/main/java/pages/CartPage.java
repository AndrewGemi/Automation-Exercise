package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementAction;

public class CartPage {
    private final WebDriver driver;
    private final By footer = By.id("footer");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public FooterPage scrollToFooterSection() {
        ElementAction.scrollToElement(driver, footer);
        return new FooterPage(driver);
    }

}
