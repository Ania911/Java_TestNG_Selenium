package Tests;

import Base.Base;
import org.testng.annotations.*;
import static utility.Constant.*;
import pageObjects.SignUpPage;
import utility.Methods;
import utility.Verification;


public class testLogin extends Base {

    @Test
    public void testSuccessUserLogin() {
        SignUpPage signUpPage = new SignUpPage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(signUpPage.loginButton);
        function.enterText(signUpPage.userName, name);
        function.enterText(signUpPage.userPass, pass);
        function.clickTheButton(signUpPage.submitButton);
        Verification.verifyElementIsPresent(signUpPage.uploadButton);
        signUpPage.logOut();
    }

    @Test
    public void testWrongUserPass() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.loginToApp(name, wrongPass);
        Verification.verifyText("Your email or password were incorrect.", signUpPage.loginError);
    }

}
