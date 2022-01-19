package utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class Methods {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTheButton(WebElement element) {
        //DONE: try to verify that the element is clickable first, then click it
        waitUntilElementToBeClickable(element);
        element.click();
    }

    public void clickTheButtonWithoutWait(WebElement element) {
        //DONE: try to verify that the element is clickable first, then click it
        element.click();
    }

    public void waitUntilElementToBeClickable(WebElement element) {
        WebDriverWait shortWait = new WebDriverWait(driver, 10);
        shortWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait shortWait = new WebDriverWait(driver, 10);
        shortWait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void elementIsDisplayed(WebElement element) {
        //DONE: Do not return true/false. Add meaningful messages to catch - Done
        // success will give you null and fail will give you false.
        assert element.isDisplayed();
    }

    public boolean elementIsNotDisplayed(WebElement element) {
        try {
            // assert !element.isDisplayed(); doesn't work for me
            element.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static Boolean elementIsSelected(WebElement element) {
        try {
            element.isSelected();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Boolean elementIsEnabled(WebElement element) {
        try {
            element.isEnabled();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static String getText(WebElement element) throws NoSuchElementException {
        String elementText = element.getText();
        System.out.println(elementText);
        return elementText;
    }

    public static void enterText(WebElement element, String name) {
        element.sendKeys(name);
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }

    public void switchToCommentPage() {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public static void selectElementOnTheList(WebElement element, String text) {
        Select selectElement = new Select(element);
        selectElement.selectByVisibleText(text);
    }

    // JavaScript accept Alert -> OK
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // JavaScript dismiss Alert -> Cancel
    public void alertClickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

    public void switchToWindowsPage() {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
    }

}
