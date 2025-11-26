package testClasses;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpLoginPage;
import utils.Gender;

public class AuthTests extends BaseTests {


    @Test
    public void register_TC1() {
        // Test code for user registration
        //3. Verify that home page is visible successfully ✅
        //4. Click on 'Signup / Login' button ✅
        //5. Verify 'New User Signup!' is visible ✅
        //6. Enter name and email address ✅
        //7. Click 'Signup' button ✅
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible ✅
        //9. Fill details: Title, Name, Email, Password, Date of birth ✅
        //10. Select checkbox 'Sign up for our newsletter!' ✅
        //11. Select checkbox 'Receive special offers from our partners!' ✅
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number ✅
        //13. Click 'Create Account button' ✅
        //14. Verify that 'ACCOUNT CREATED!' is visible ✅
        //15. Click 'Continue' button ✅
        //16. Verify that 'Logged in as username' is visible ✅
        //17. Click 'Delete Account' button ✅
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button ✅
        new HomePage(driver)
                .checkHomePageVisible()
                .clickSignupLogin();
        Register(
                "Weyita",
                "weyita2764@izeao.com",
                Gender.Mr, "12345678",
                "10", "5", "1995",
                "Weyita", "Tadesse",
                "Some Company",
                "123 Main St", "Apt 4B",
                "United States", "California", "Los Angeles", "90001",
                "1234567890"
        );
        deleteAccount();
    }

    @Test
    public void loginWithCorrectEmailAndPassword_TC2() {
//        1. Launch browser ✅
//        2. Navigate to url 'http://automationexercise.com' ✅
//        3. Verify that home page is visible successfully ✅
//        4. Click on 'Signup / Login' button ✅
//        5. Verify 'Login to your account' is visible ✅
//        6. Enter correct email address and password ✅
//        7. Click 'login' button ✅
//        8. Verify that 'Logged in as username' is visible ✅
//        9. Click 'Delete Account' button ✅
//        10. Verify that 'ACCOUNT DELETED!' is visible ✅
        new HomePage(driver)
                .checkHomePageVisible()
                .clickSignupLogin();
        Register(
                "Weyita",
                "weyita2764@izeao.com",
                Gender.Mr, "12345678",
                "10", "5", "1995",
                "Weyita", "Tadesse",
                "Some Company",
                "123 Main St", "Apt 4B",
                "United States", "California", "Los Angeles", "90001",
                "1234567890"
        );
        Logout();
        Login("weyita2764@izeao.com", "12345678");
        deleteAccount();
    }

    @Test
    public void loginWithInCorrectEmailAndPassword_TC3() {
//        1. Launch browser ✅
//        2. Navigate to url 'http://automationexercise.com' ✅
//        3. Verify that home page is visible successfully ✅
//        4. Click on 'Signup / Login' button ✅
//        5. Verify 'Login to your account' is visible ✅
//        6. Enter correct email address and password ✅
//        7. Click 'login' button ✅
//        8. Verify that 'Logged in as username' is visible ✅
//        9. Click 'Delete Account' button ✅
//        10. Verify that 'ACCOUNT DELETED!' is visible ✅
        new HomePage(driver)
                .checkHomePageVisible()
                .clickSignupLogin();

        new SignUpLoginPage(driver)
                .verifyLoginToYourAccountVisible()
                .enterLoginEmailAndPassword(
                        "weyita2764@izeao.com", "12345678"
                )
                .clickLoginButton();
        new SignUpLoginPage(driver)
                .verifyLoginErrorMessageVisible();
    }

    @Test
    public void logoutAfterLogin_TC4() {
        new HomePage(driver)
                .checkHomePageVisible()
                .clickSignupLogin();
        Login("andrewgamal7@gmail.com", "01278656727");
        Logout();
    }

    @Test
    public void registerWithExistingEmail_TC5() {
        new HomePage(driver)
                .checkHomePageVisible()
                .clickSignupLogin();
        new SignUpLoginPage(driver)
                .verifyNewUserSignupVisible()
                .enterNameAndEmail("Weyita", "andrewgamal7@gmail.com")
                .clickSignUpButton()
                .verifyEmailAlreadyExistErrorMessageVisible();
    }


    public void Register(String name, String email, Gender gender, String password,
                         String day, String month, String year,
                         String firstName, String lastName, String company,
                         String address1, String address2, String country,
                         String state, String city, String zipcode,
                         String mobileNumber) {
        new SignUpLoginPage(driver)
                .verifyNewUserSignupVisible()
                .enterNameAndEmail(name, email)
                .clickSignUpButton()
                .verifyHeadingEnterAccountInformationVisible()
                .enterAccountInformation(
                        gender,
                        name,
                        password,
                        day,
                        month,
                        year
                )
                .selectNewsLetterCheckbox()
                .selectSpecialOffersCheckbox()
                .fillPersonalDetails(
                        firstName,
                        lastName,
                        company,
                        address1,
                        address2,
                        country,
                        state,
                        city,
                        zipcode,
                        mobileNumber
                )
                .clickCreateAccountButton()
                .verifyAccountCreatedVisible()
                .clickContinueButton();
    }

    public void Login(String email, String password) {
        new SignUpLoginPage(driver)
                .verifyLoginToYourAccountVisible()
                .enterLoginEmailAndPassword(email, password)
                .clickLoginButton();
    }

    public void Logout() {
        new HomePage(driver)
                .verifyLoggedInAsUsernameVisible()
                .clickLogOutButton()
                .verifyLoginToYourAccountVisible();

    }

    public void deleteAccount() {
        new HomePage(driver)
                .verifyLoggedInAsUsernameVisible()
                .clickDeleteAccountButton()
                .verifyAccountDeletedVisible();
    }
}
