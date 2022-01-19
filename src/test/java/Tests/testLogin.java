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
        function.clickTheButtonWithoutWait(signUpPage.loginButton);
        Methods.enterText(signUpPage.userName, name);
        Methods.enterText(signUpPage.userPass, pass);
        function.clickTheButtonWithoutWait(signUpPage.submitButton);
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
