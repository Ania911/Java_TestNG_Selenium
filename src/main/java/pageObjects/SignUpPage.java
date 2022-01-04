package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    protected WebDriver driver;


    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement userPass;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//a[@href='/submit']")
    public WebElement uploadButton;

    @FindBy(xpath = "//img[@alt='Avatar']")
    public WebElement avatarIcon;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//p[@class='error-message red']")
    public WebElement loginError;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToApp(String name, String pass) {
        loginButton.click();
        userName.sendKeys(name);
        userPass.sendKeys(pass);
        submitButton.click();
    }

    public void logOut() {
        avatarIcon.click();
        logoutButton.click();
    }


}
