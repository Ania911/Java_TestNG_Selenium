package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/login']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement userPass;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//a[@href='/submit']")
    WebElement uploadButton;

    @FindBy(xpath = "//img[@alt='Avatar']")
    WebElement avatarIcon;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//p[@class='error-message red']")
    WebElement loginError;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToApp(String name, String pass) {
        loginButton.click();
        userName.sendKeys(name);
        userPass.sendKeys(pass);
        submitButton.click();
        uploadButton.isDisplayed();
    }

    public void failLoginToApp(String name, String pass) {
        loginButton.click();
        userName.sendKeys(name);
        userPass.sendKeys(pass);
        submitButton.click();
    }

    public void logOut() {
        avatarIcon.click();
        logoutButton.click();
    }

    public String loginError() {
        return loginError.getText();
    }


}
