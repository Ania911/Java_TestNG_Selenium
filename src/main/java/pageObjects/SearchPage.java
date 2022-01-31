package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Verification;

public class SearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class = 'search']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@name = 'query']")
    public WebElement inputSearchQuery;

    @FindBy(xpath = "//a[@href= '/tag/tesla?ref=search']")
    public WebElement suggestedSearchResultForTesla;

    @FindBy(xpath = "//input[@id= 'search-hero']")
    public WebElement searchBar;

    @FindBy(xpath = "//a[contains(@href,'tesla')]")
    public WebElement teslaSearchResultLink;

    @FindBy(xpath = "//a[contains(@href,'apple')]")
    public WebElement appleSearchResultLink;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
