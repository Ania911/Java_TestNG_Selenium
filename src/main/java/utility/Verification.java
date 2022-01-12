package utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;


public class Verification {

    public static void verifyElementIsPresent(WebElement element) throws NoSuchElementException {
        assertTrue(element.isDisplayed());
    }

    public  static void verifyUrl(String text, String text1) throws NoSuchElementException {
        assertEquals(text, text1);
    }

    public static void verifyCommentUrl(String text, String text1) throws NoSuchElementException {
        assertNotEquals(text, text1);
    }

    public static void verifyText(String text, WebElement element) throws NoSuchElementException {
        String getText = element.getText();
        assertEquals(getText, text);
    }

}
