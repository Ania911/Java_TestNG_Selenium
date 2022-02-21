package utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.SearchPage;

import java.time.Duration;
import java.util.ArrayList;


public class Methods {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public Methods(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickTheButton(WebElement element) {
        //DONE: try to verify that the element is clickable first, then click it
        waitUntilElementToBeClickable(element);
        element.click();
    }

    public void clickTheButtonWithoutWait(WebElement element) {
        element.click();
    }

    public void waitUntilElementToBeClickable(WebElement element) {
        WebDriverWait shortWait = new WebDriverWait(driver, 10);
        shortWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait shortWait = new WebDriverWait(driver, 10);
        shortWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void elementIsDisplayed(WebElement element) {
        //DONE: Do not return true/false. Add meaningful messages to catch - Done
        // success will give you null and fail will give you false.
       // waitUntilElementIsVisible(element);
        assert element.isDisplayed();
    }

    public boolean elementIsNotDisplayed(WebElement element) {
        try {
            //TODO: Try to make it work, find a solution to assert negative (e.g. NOT displayed)
            // assert !element.isDisplayed(); doesn't work for me
            element.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static void elementIsSelected(WebElement element) {
            //DONE: Do assertions in all methods
            assert element.isSelected();
    }

    public void elementIsEnabled(WebElement element) {
            element.isEnabled();
    }

    public static String getText(WebElement element) throws NoSuchElementException {
        String elementText = element.getText();
        System.out.println(elementText);
        return elementText;
    }

    public void enterText(WebElement element, String name) {
        waitUntilElementToBeClickable(element);
        element.sendKeys(name);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void goTo(String url) {
        driver.navigate().to(url);
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

    public void enterSearchText(String text) {
        SearchPage search = new SearchPage(driver);
        clickTheButton(search.searchButton);
        waitUntilElementToBeClickable(search.inputSearchQuery);
        search.inputSearchQuery.sendKeys(text);
    }

    public void enterSearchTextAndClickEnter(String text) {
        SearchPage search = new SearchPage(driver);
        clickTheButton(search.searchButton);
        waitUntilElementToBeClickable(search.inputSearchQuery);
        search.inputSearchQuery.sendKeys(text, Keys.ENTER);
    }

    public void implicitlyWait(Integer number) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(number));
    }

}
