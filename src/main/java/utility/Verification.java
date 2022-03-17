package utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;


public class Verification {

    private static WebDriver driver;

    public Verification(WebDriver driver) {
        this.driver = driver;
    }

    public static void verifyElementIsPresent(WebElement element) throws NoSuchElementException {
        Methods function = new Methods(driver);
        function.elementIsDisplayed(element);
    }

    public static void verifyUrl(String text, String text1) throws NoSuchElementException {
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
