package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import verification.Verification;

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

    @FindBy(xpath = "//a[@href='/hot' and @class='label']")
    public WebElement hotLabel;

    public SubMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
