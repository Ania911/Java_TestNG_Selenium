package utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;


public class Methods {
    private WebDriver driver;
    private WebDriver.Navigation navigate;


    public Methods(WebDriver driver) {
        this.driver = driver;
    }


    public static void clickOnTheButton(WebElement element) {
        element.click();
    }

    public static boolean elementIsDisplayed(WebElement element) {
        try {
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

    public  Boolean elementIsEnabled(WebElement element) {
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

}
