package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Verification;
import java.util.ArrayList;
import static org.testng.Assert.assertEquals;


public class HomePage {
    private WebDriver driver;


    @FindBy(xpath = "//a[@href='/hot']")
    public WebElement hotButton;

    @FindBy(xpath = "//a[@href='/hot' and @class='label']")
    public WebElement hotLabel;

    @FindBy(xpath = "//a[@href='/trending']")
    public WebElement trendingButton;

    @FindBy(xpath = "//a[@href = '/tag/spider-man?ref=featured-tag']")
    public WebElement spiderManButton;

    @FindBy(xpath = "//a[@href = '/tag/top-gifs-2021?ref=featured-tag']")
    public WebElement topButton;

    @FindBy(xpath = "//a[@href = '/tag/omicron?ref=featured-tag']")
    public WebElement omicronButton;

    @FindBy(xpath = "//a[@data-position = '1']")
    public WebElement commentButton;

    @FindBy(xpath = "//h2[contains(text(),'Funny')]")
    public WebElement funnyText;

    @FindBy(xpath = "//h3[contains(text(),'Favorites')]")
    public WebElement favoriteText;

    @FindBy(xpath = "//a[@href = 'https://bit.ly/ShuffleNav']")
    public WebElement shuffleNavButton;

    @FindBy(xpath = "//a[@href = 'https://bit.ly/2WbA6LN']")
    public WebElement getAppButton;

    @FindBy(xpath = "//a[@href = 'javascript:void(0);']")
    public WebElement menuButton;

    @FindBy(xpath = "//i[@class='icon star']")
    public WebElement starIcon;

    @FindBy(xpath = "//a[@class='button favorite']")
    public WebElement favoriteButton;

    @FindBy(xpath = "//a[@href='/funny']")
    public WebElement funnyButton;

    @FindBy(xpath = "//h3[contains(text(),'Recents')]")
    public WebElement recentText;

    @FindBy(xpath = "//i[@class='icon close']")
    public WebElement iconClose;

    @FindBy(xpath = "//a[@class='button-clear']")
    public WebElement buttonClear;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void verifyHotUrl() {
        String strUrl = driver.getCurrentUrl();
        Verification.verifyUrl(strUrl, "https://9gag.com/hot");
    }

    public void verifyTrendingUrl() {
        String strUrl = driver.getCurrentUrl();
        Verification.verifyUrl(strUrl, "https://9gag.com/trending");
    }

    public void navigateBackAndForward() {
        hotButton.click();
        driver.navigate().back();
        String strUrl = driver.getCurrentUrl();
        Verification.verifyUrl(strUrl, "https://9gag.com/");
        driver.navigate().forward();
        String strUrl2 = driver.getCurrentUrl();
        Verification.verifyUrl(strUrl2, "https://9gag.com/hot");
    }

    public void navigateToFunnyUrl() {
        driver.navigate().to("https://9gag.com/funny");
        String text = funnyText.getText();
        assertEquals(text, "Funny");
    }


}

