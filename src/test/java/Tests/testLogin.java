package Tests;

import Base.Base;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class testLogin extends Base {


    @Test
    public void testSuccessUserLogin() {
        signUpPage.loginToApp("anya.bardun@gmail.com", "testqa911@//");
        assertTrue(true, "Couldn't log in to the app ");
    }

    @Test
    public void testWrongUserPass() {
        signUpPage.failLoginToApp("anya.bardun@gmail.com", "testqa");
        assertEquals(signUpPage.loginError(),
                "Your email or password were incorrect.");
    }


}
