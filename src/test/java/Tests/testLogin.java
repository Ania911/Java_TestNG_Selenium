package Tests;

import Base.Base;
import org.testng.annotations.*;
import static utility.Constant.*;

import pageObjects.SignUpPage;
import utility.Methods;
import utility.Verification;


public class testLogin extends Base {

    private SignUpPage signUpPage;
    private Methods function;

    @BeforeMethod
    public void setUp() {
        signUpPage = new SignUpPage(driver);
        function = new Methods(driver);
    }

    @AfterMethod
    public void tearDownAfter() {
        signUpPage = null;
        function = null;
    }

    @Test
    public void testSuccessUserLogin() {
        function.clickTheButton(signUpPage.loginButton);
        function.enterText(signUpPage.userName, name);
        function.enterText(signUpPage.userPass, pass);
        function.clickTheButton(signUpPage.submitButton);
        function.elementIsDisplayed(signUpPage.uploadButton);
        signUpPage.logOut();
    }

    @Test
    public void testWrongUserPass() {
        signUpPage.loginToApp(name, wrongPass);
        Verification.verifyText("Your email or password were incorrect.", signUpPage.loginError);
    }

}
