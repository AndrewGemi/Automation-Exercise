package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementAction;


public class ContactUsPage {
    private final By getInTouchHeading = By.xpath("//h2[contains(text(),'Get In Touch')]");
    private final By nameInput = By.xpath("//input[@data-qa ='name']");
    private final By emailInput = By.xpath("//input[@data-qa ='email']");
    private final By subjectInput = By.xpath("//input[@data-qa ='subject']");
    private final By messageTextArea = By.id("message");
    private final By uploadFileInput = By.name("upload_file");
    private final By submitButton = By.xpath("//input[@data-qa ='submit-button']");
    private final By successMessage = By.xpath("//div[@class='contact-form'] //div[contains(text(),'Success! Your details have been submitted successfully.')]");
    private final By homeButton = By.cssSelector("#form-section > a");

    private WebDriver driver;


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ContactUsPage verifyGetInTouchVisible() {
        Assert.assertTrue(ElementAction.findElement(driver, getInTouchHeading).isDisplayed(), "'Get In Touch' heading is not visible");
        return this;
    }

    public ContactUsPage fillContactUsForm(String name, String email, String subject, String message) {
        ElementAction.findElement(driver, nameInput).sendKeys(name);
        ElementAction.findElement(driver, emailInput).sendKeys(email);
        ElementAction.findElement(driver, subjectInput).sendKeys(subject);
        ElementAction.findElement(driver, messageTextArea).sendKeys(message);
        return this;
    }

    public ContactUsPage uploadFile(String filePath) {
        ElementAction.findElement(driver, uploadFileInput).sendKeys(filePath);
        return this;
    }

    public ContactUsPage clickSubmitButton() {
        ElementAction.findElement(driver, submitButton).click();
        return this;
    }

    public ContactUsPage handleAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public ContactUsPage verifySuccessMessagVisible() {
        Assert.assertTrue(ElementAction.findElement(driver, successMessage).isDisplayed(), "Success message is not visible");
        return this;
    }

    public HomePage clickHomeButton() {
        ElementAction.findElement(driver, homeButton).click();
        return new HomePage(driver);
    }
}
