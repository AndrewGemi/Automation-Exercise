package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementAction {


    public static WebElement findElement(WebDriver driver, By locator
    ) {
        return driver.findElement(locator
        );
    }

    public static List<WebElement> findElements(WebDriver driver, By locator
    ) {
        return driver.findElements(locator
        );
    }

    public static boolean isVisible(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        return ElementAction.findElement(driver, locator).isDisplayed();
    }

    // scroll to
    public static void scrollToElement(WebDriver driver, By locator) {
        WebElement element = findElement(driver, locator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
