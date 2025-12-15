package testClasses;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Gender;

public class CheckoutTests extends BaseTests {
    @Test
    public void  PlaceOrderRegisterWhileCheckout_TC14(){
        new HomePage(driver)
                .checkHomePageVisible()
                .closeAdIfPresent()
                .clickAddToCartButton(1)
                .clickViewCartModalButton()
                .clickProceedToCheckoutButtonNotRegistered()
                .verifyRegisterLoginPageVisible()
                .clickRegisterLoginButton()
                .verifyNewUserSignupVisible()
                .enterNameAndEmail(
                        "Wesily",
                        "wesilyandrew@abbbbb.com"
                )
                .clickSignUpButton()
                .verifyHeadingEnterAccountInformationVisible()
                .closeAdIfPresent()
                .enterAccountInformation(
                        Gender.Mr,
                        "Wesily",
                        "password123",
                        "10",
                        "5",
                        "1990"
                )
                .selectNewsLetterCheckbox()
                .selectSpecialOffersCheckbox()
                .fillPersonalDetails(
                        "Wesily",
                        "Andrews",
                        "Tech Solutions",
                        "123 Tech Street",
                        "Suite 100",
                        "United States",
                        "California",
                        "San Francisco",
                        "94107",
                        "1234567890"
                )
                .clickCreateAccountButton()
                .verifyAccountCreatedVisible()
                .clickContinueButton()
                .verifyLoggedInAsUsernameVisible()
                .clickHeaderCartButton()
                .clickProceedToCheckoutButtonRegistered()
                .addComments("Please deliver between 9 AM to 5 PM.")
                .clickPlaceOrderButton()
                .enterPaymentDetails(
                        "Wesily Andrews",
                        "4111111111111111",
                        "12",
                        "2025",
                        "123"
                )
                .clickPayAndConfirmOrderButton()
                .verifyOrderConfirmationMessageVisible()
                .clickContinueShoppingButton()
                .clickDeleteAccountButton()
                .verifyAccountDeletedVisible()
                .clickContinueButton();
    }

    @Test
    public void  PlaceOrderRegisterBeforeCheckout_TC15(){
        new HomePage(driver)
                .checkHomePageVisible()
                .closeAdIfPresent()
                .clickSignupLogin()
                .verifyNewUserSignupVisible()
                .enterNameAndEmail(
                        "Wesily",
                        "wesilyandrew@abbbbb.com"
                )
                .clickSignUpButton()
                .verifyHeadingEnterAccountInformationVisible()
                .closeAdIfPresent()
                .enterAccountInformation(
                        Gender.Mr,
                        "Wesily",
                        "password123",
                        "10",
                        "5",
                        "1990"
                )
                .selectNewsLetterCheckbox()
                .selectSpecialOffersCheckbox()
                .fillPersonalDetails(
                        "Wesily",
                        "Andrews",
                        "Tech Solutions",
                        "123 Tech Street",
                        "Suite 100",
                        "United States",
                        "California",
                        "San Francisco",
                        "94107",
                        "1234567890"
                )
                .clickCreateAccountButton()
                .verifyAccountCreatedVisible()
                .clickContinueButton()
                .verifyLoggedInAsUsernameVisible()
                .clickAddToCartButton(1)
                .clickViewCartModalButton()
                .clickProceedToCheckoutButtonRegistered()
                .addComments("Please deliver between 9 AM to 5 PM.")
                .clickPlaceOrderButton()
                .enterPaymentDetails(
                        "Wesily Andrews",
                        "4111111111111111",
                        "12",
                        "2025",
                        "123"
                )
                .clickPayAndConfirmOrderButton()
                .verifyOrderConfirmationMessageVisible()
                .clickContinueShoppingButton()
                .clickDeleteAccountButton()
                .verifyAccountDeletedVisible()
                .clickContinueButton();
    }
    @Test
    public void  PlaceOrderLoginBeforeCheckout_TC16(){
        new HomePage(driver)
                .checkHomePageVisible()
                .closeAdIfPresent()
                .clickSignupLogin()
                .verifyNewUserSignupVisible()
                .enterLoginEmailAndPassword(
                        "wesilyandrew@a.com",
                        "password123"
                )
                .clickLoginButton()
                .verifyLoggedInAsUsernameVisible()
                .clickAddToCartButton(1)
                .clickViewCartModalButton()
                .clickProceedToCheckoutButtonRegistered()
                .addComments("Please deliver between 9 AM to 5 PM.")
                .clickPlaceOrderButton()
                .enterPaymentDetails(
                        "Wesily Andrews",
                        "4111111111111111",
                        "12",
                        "2025",
                        "123"
                )
                .clickPayAndConfirmOrderButton()
                .verifyOrderConfirmationMessageVisible()
                .clickContinueShoppingButton()
                .clickDeleteAccountButton()
                .verifyAccountDeletedVisible()
                .clickContinueButton();
    }
}
