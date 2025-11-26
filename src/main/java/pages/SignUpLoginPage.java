package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.ElementAction;

public class SignUpLoginPage {
    private final WebDriver driver;
    private final By headingNewUserSignup = By.xpath("//h2[.='New User Signup!']");
    private final By signUpNameInput = By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By signUpEmailInput = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By headingEnterAccountInformation = By.xpath("//b[.='Enter Account Information']");
    private final By titleMrRadio = By.id("id_gender1");
    private final By name = By.id("name");
    private final By password = By.id("password");
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");
    private final By newsLetterCheckbox = By.id("newsletter");
    private final By specialOffersCheckbox = By.id("optin");
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address1 = By.id("address1");
    private final By address2 = By.id("address2");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private final By accountCreatedHeading = By.xpath("//b[.='Account Created!']");
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private final By loggedInAsUsername = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By deleteAccountButton = By.xpath("//a[.=' Delete Account']");
    private final By accountDeletedHeading = By.xpath("//b[.='Account Deleted!']");

    public SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpLoginPage verifyNewUserSignupVisible() {
        ElementAction.findElement(driver, headingNewUserSignup).isDisplayed();
        return this;
    }

    public SignUpLoginPage enterNameAndEmail(String name, String email) {
        ElementAction.findElement(driver, signUpNameInput).sendKeys(name);
        ElementAction.findElement(driver, signUpEmailInput).sendKeys(email);
        return this;
    }

    public SignUpLoginPage clickSignUpButton() {
        ElementAction.findElement(driver, signUpButton).click();
        return this;
    }

    public SignUpLoginPage verifyHeadingEnterAccountInformationVisible() {
        ElementAction.findElement(driver, headingEnterAccountInformation).isDisplayed();
        return this;
    }

    public SignUpLoginPage enterAccountInformation() {
        // Implementation for entering account information
        ElementAction.findElement(driver, titleMrRadio).click();
        ElementAction.findElement(driver, name).sendKeys("Seyit");
        ElementAction.findElement(driver, password).sendKeys("12345");
        new Select(ElementAction.findElement(driver, days)).selectByValue("10");
        new Select(ElementAction.findElement(driver, months)).selectByValue("5");
        new Select(ElementAction.findElement(driver, years)).selectByValue("1990");

        return this;
    }

    public SignUpLoginPage selectNewsLetterCheckbox() {
        ElementAction.findElement(driver, newsLetterCheckbox).click();
        return this;
    }

    public SignUpLoginPage selectSpecialOffersCheckbox() {
        ElementAction.findElement(driver, specialOffersCheckbox).click();
        return this;
    }

    public SignUpLoginPage fillPersonalDetails() {
        ElementAction.findElement(driver, firstName).sendKeys("Seyit");
        ElementAction.findElement(driver, lastName).sendKeys("Kaya");
        ElementAction.findElement(driver, company).sendKeys("Tech Company");
        ElementAction.findElement(driver, address1).sendKeys("123 Main St");
        ElementAction.findElement(driver, address2).sendKeys("Apt 4B");
        new Select(ElementAction.findElement(driver, country)).selectByVisibleText("United States");
        ElementAction.findElement(driver, state).sendKeys("California");
        ElementAction.findElement(driver, city).sendKeys("Los Angeles");
        ElementAction.findElement(driver, zipcode).sendKeys("90001");
        ElementAction.findElement(driver, mobileNumber).sendKeys("1234567890");
        return this;
    }

    public SignUpLoginPage clickCreateAccountButton() {
        ElementAction.findElement(driver, createAccountButton).click();
        return this;
    }

    public SignUpLoginPage verifyAccountCreatedVisible() {
        ElementAction.findElement(driver, accountCreatedHeading).isDisplayed();
        return this;
    }

    public SignUpLoginPage clickContinueButton() {
        ElementAction.findElement(driver, continueButton).click();
        return this;
    }

    public SignUpLoginPage verifyLoggedInAsUsernameVisible() {
        ElementAction.findElement(driver, loggedInAsUsername).isDisplayed();
        return this;
    }

    public SignUpLoginPage clickDeleteAccountButton() {
        ElementAction.findElement(driver, deleteAccountButton).click();
        return this;
    }

    public void verifyAccountDeletedVisible() {
        ElementAction.findElement(driver, accountDeletedHeading).isDisplayed();
        System.out.println("Account deleted successfully");
//        return this;
    }

}
