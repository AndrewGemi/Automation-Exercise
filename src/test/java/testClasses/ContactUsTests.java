package testClasses;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

public class ContactUsTests extends BaseTests {

    @Test
    public void Contact_Us_Form_TC6() {
        new HomePage(driver)
                .checkHomePageVisible()
                .clickContactUsButton()
                .verifyGetInTouchVisible()
                .fillContactUsForm(
                        "Weyita Tadesse",
                        "weyita2764@izeao.com",
                        "Subject Example",
                        "This is a message for testing purposes."
                )
                .uploadFile(
                        System.getProperty("user.dir") + "/src/test/resources/testFiles/sample.txt"
                )
                .clickSubmitButton()
                .handleAlert()
                .verifySuccessMessagVisible()
                .clickHomeButton()
                .checkHomePageVisible();

    }

}
