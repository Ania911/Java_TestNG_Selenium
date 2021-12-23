package Tests;

import Base.Base;
import org.testng.annotations.*;
import static utility.Constant.*;
import verification.Verification;


public class testLogin extends Base {

    Verification verification = new Verification();


    @Test
    public void testSuccessUserLogin() {
        signUpPage.clickLoginButton();
        signUpPage.enterUserName(name);
        signUpPage.enterPass(pass);
        signUpPage.clickSubmitButton();
        verification.verifyElementIsPresent(signUpPage.uploadButton);
    }

    @Test
    public void testWrongUserPass() {
        signUpPage.loginToApp(name, wrongPass);
        verification.verifyTextError("Your email or password were incorrect.", signUpPage.loginError);
    }


}
