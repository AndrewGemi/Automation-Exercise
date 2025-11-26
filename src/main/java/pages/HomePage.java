package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementAction;

public class HomePage {
    private final WebDriver driver;
    private final By slider = By.id("slider");
    private final By signupLogin = By.xpath("//a[contains(text(),'Signup / Login')]");

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

    public void clickSignupLogin() {
        ElementAction.findElement(driver, signupLogin).click();
    }
}
