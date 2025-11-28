package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementAction;

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

}
