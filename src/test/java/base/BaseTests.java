package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests { // this class contains all before and after methods for tests
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // add any needed options — e.g. headless, disable-infobars, etc.
        options.addArguments("--start-maximized");
        // options.addArguments("--headless");  // if you want headless mode

        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com/");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
