package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href = 'javascript:void(0);']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@name = 'query']")
    public WebElement enterSearchQuery;

    public Search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
