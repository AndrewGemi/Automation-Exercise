package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private Waits() {
    }

    //Functions to wait for an element to be present, visible, or clickable (Locators)
    public static WebElement waitForElementPresent(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(driver1 -> ElementAction.findElement(driver, locator));
    }


    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(driver1 -> {
            WebElement element = waitForElementPresent(driver, locator);
            return element.isDisplayed() ? element : null;
        });
    }


    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(driver1 -> {
            WebElement element = waitForElementVisible(driver, locator);
            return element.isEnabled() ? element : null;
        });
    }


    public static WebElement waitForElementPresent(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(driver1 -> element);
    }

    public static WebElement waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(driver1 -> {
            WebElement element1 = waitForElementPresent(driver, element);
            return element.isDisplayed() ? element : null;
        });
    }

    public static WebElement waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(driver1 -> {
            WebElement element1 = waitForElementVisible(driver, element);
            return element.isEnabled() ? element : null;
        });
    }
}
