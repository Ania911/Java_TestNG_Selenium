package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubMenuPage {

    private WebDriver driver;

    @FindBy(xpath = "//i[@class='icon more']")
     public WebElement iconMore;

    @FindBy(xpath = "//i[@class='icon more']")
    public List<WebElement> iconMoreList;

    @FindBy(xpath = "//*[contains(text(),'Top Posts')]")
    public WebElement topPosts;

    @FindBy(xpath = "//*[contains(text(),'Most Recent')]")
    public WebElement mostRecent;

    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div/section[1]/ul/li[1]/div/ul/li[1]")
    public WebElement selectedOption;

    @FindBy(xpath = "//a[@href='/hot' and @class='label']")
    public WebElement hotLabel;

    @FindBy(xpath = "//div[@class='menu']")
    public WebElement menu;


    public SubMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
