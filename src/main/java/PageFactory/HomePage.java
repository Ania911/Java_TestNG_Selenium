package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class HomePage {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    @FindBy(xpath = "//a[@href='/hot']")
    WebElement hotButton;

    @FindBy(xpath = "//a[@href='/trending']")
    WebElement trendingButton;

    @FindBy(xpath = "//a[@href = '/tag/spider-man?ref=featured-tag']")
    WebElement spiderManButton;

    @FindBy(xpath = "//a[@href = '/tag/top-gifs-2021?ref=featured-tag']")
    WebElement topButton;

    @FindBy(xpath = "//a[@href = '/tag/omicron?ref=featured-tag']")
    WebElement omicronButton;

    @FindBy(xpath = "//a[@data-position = '1']")
    WebElement commentButton;

    @FindBy(xpath = "//h2[contains(text(),'Funny')]")
    WebElement funnyText;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnHotButton() {
        hotButton.click();
        String strUrl = driver.getCurrentUrl();
        assertEquals(strUrl, "https://9gag.com/hot");
        spiderManButton.isDisplayed();
        topButton.isDisplayed();
        omicronButton.isDisplayed();
    }

    public void clickOnTrendingButton() {
        trendingButton.click();
        String strUrl = driver.getCurrentUrl();
        assertEquals(strUrl, "https://9gag.com/trending");
    }

    public void clickOnCommentButton() {
        commentButton.click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
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

    public void navigateBackAndForward() {
        hotButton.click();
        driver.navigate().back();
        String strUrl = driver.getCurrentUrl();
        assertEquals(strUrl, "https://9gag.com/");
        driver.navigate().forward();
        String strUrl2 = driver.getCurrentUrl();
        assertEquals(strUrl2, "https://9gag.com/hot");
    }

    public void navigateToFunnyUrl() {
        // goTo("https://9gag.com/funny");
        driver.navigate().to("https://9gag.com/funny");
        String text = funnyText.getText();
        assertEquals(text, "Funny");
    }


}

