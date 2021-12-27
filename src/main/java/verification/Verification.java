package verification;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.testng.Assert.*;


public class Verification {

    public void verifyElementIsPresent(WebElement element) throws NoSuchElementException {
        assertTrue(element.isDisplayed());
    }

    public void verifyUrl(String text, String text1) throws NoSuchElementException {
        assertEquals(text, text1);
    }

    public void verifyCommentUrl(String text, String text1) throws NoSuchElementException {
        assertNotEquals(text, text1);
    }

    public void verifyText(String text, WebElement element) throws NoSuchElementException {
        String getText = element.getText();
        assertEquals(getText, text);
    }

}
