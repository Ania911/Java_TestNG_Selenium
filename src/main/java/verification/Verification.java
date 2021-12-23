package verification;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pageObjects.SignUpPage;

import static org.testng.Assert.*;

public class Verification {


    public void verifyElementIsPresent(WebElement element) throws NoSuchElementException {
        assertTrue(element.isDisplayed());
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void verifyTextError(String text, WebElement element) throws NoSuchElementException {
        String getText = getText(element);
        assertEquals(getText, text);
    }

    public void verifyUrlText(String text, String text1) throws NoSuchElementException {
        assertEquals(text, text1);
    }

    public void verifyCommentUrl(String text, String text1) throws NoSuchElementException {
        assertNotEquals(text, text1);
    }

}
