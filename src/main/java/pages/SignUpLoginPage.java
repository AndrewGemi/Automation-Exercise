package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ElementAction;
import utils.Gender;

public class SignUpLoginPage {
    private final WebDriver driver;
    // Register locators
    private final By headingNewUserSignup = By.xpath("//h2[.='New User Signup!']");
    private final By signUpNameInput = By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By signUpEmailInput = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By headingEnterAccountInformation = By.xpath("//b[.='Enter Account Information']");
    private final By titleMrRadio = By.id("id_gender1");
    private final By titleMsRadio = By.id("id_gender2");
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
    private final By signUpErrorMessage = By.xpath("//p[contains(text(),'Email Address already exist!')]");

    // Login locators
    private final By headingLoginToYourAccount = By.xpath("//h2[.='Login to your account']");
    private final By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By loginErrorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

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

    public SignUpLoginPage enterAccountInformation(Gender gender, String inName, String inPassword, String day, String month, String year) {
        // Implementation for entering account information
        ElementAction.findElement(driver, gender == Gender.Mr ? titleMrRadio : titleMsRadio).click();
        ElementAction.findElement(driver, name).sendKeys(inName);
        ElementAction.findElement(driver, password).sendKeys(inPassword);
        new Select(ElementAction.findElement(driver, days)).selectByValue(day);
        new Select(ElementAction.findElement(driver, months)).selectByValue(month);
        new Select(ElementAction.findElement(driver, years)).selectByValue(year);

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

    public SignUpLoginPage fillPersonalDetails(String firstname, String lastname, String comp, String addr1, String addr2,
                                               String countryName, String stat, String cit, String zip, String mobile) {
        ElementAction.findElement(driver, firstName).sendKeys(firstname);
        ElementAction.findElement(driver, lastName).sendKeys(lastname);
        ElementAction.findElement(driver, company).sendKeys(comp);
        ElementAction.findElement(driver, address1).sendKeys(addr1);
        ElementAction.findElement(driver, address2).sendKeys(addr2);
        new Select(ElementAction.findElement(driver, country)).selectByVisibleText(countryName);
        ElementAction.findElement(driver, state).sendKeys(stat);
        ElementAction.findElement(driver, city).sendKeys(cit);
        ElementAction.findElement(driver, zipcode).sendKeys(zip);
        ElementAction.findElement(driver, mobileNumber).sendKeys(mobile);
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

    public void clickContinueButton() {
        ElementAction.findElement(driver, continueButton).click();
    }

    public void verifyEmailAlreadyExistErrorMessageVisible() {
        Assert.assertTrue(ElementAction.findElement(driver, signUpErrorMessage).isDisplayed(),
                "Sign up error message is not visible");
    }

    // Additional methods for login
    public SignUpLoginPage verifyLoginToYourAccountVisible() {
        ElementAction.findElement(driver, headingLoginToYourAccount).isDisplayed();
        return this;
    }

    public SignUpLoginPage enterLoginEmailAndPassword(String email, String password) {
        ElementAction.findElement(driver, loginEmailInput).sendKeys(email);
        ElementAction.findElement(driver, loginPasswordInput).sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        ElementAction.findElement(driver, loginButton).click();
        return new HomePage(driver);
    }

    public void verifyLoginErrorMessageVisible() {
        Assert.assertTrue(ElementAction.findElement(driver, loginErrorMessage).isDisplayed(),
                "Login error message is not visible");

    }

}
