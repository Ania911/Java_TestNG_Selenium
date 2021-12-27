package Tests;

import Base.Base;
import org.testng.annotations.*;
import static utility.Constant.*;

import verification.Methods;
import verification.Verification;


public class testLogin extends Base {

    Verification verification = new Verification();
    Methods function = new Methods();


    @Test
    public void testSuccessUserLogin() {
        function.clickOnTheButton(signUpPage.loginButton);
        function.enterText(signUpPage.userName, name);
        function.enterText(signUpPage.userPass, pass);
        function.clickOnTheButton(signUpPage.submitButton);
        verification.verifyElementIsPresent(signUpPage.uploadButton);
    }

    @Test
    public void testWrongUserPass() {
        signUpPage.loginToApp(name, wrongPass);
        verification.verifyText("Your email or password were incorrect.", signUpPage.loginError);
    }


}
