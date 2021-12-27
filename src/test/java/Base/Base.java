package Base;

import pageObjects.CommentPage;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.SubMenuPage;
import verification.Verification;

import java.util.concurrent.TimeUnit;


public class Base {

    protected SignUpPage signUpPage;
    protected HomePage homePage;
    protected CommentPage commentPage;
    protected SubMenuPage subMenuPage;

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://9gag.com/");


        signUpPage = new SignUpPage(driver);
        homePage = new HomePage(driver);
        commentPage = new CommentPage(driver);
        subMenuPage = new SubMenuPage(driver);

    }

    public void backToHomePage() {
        driver.get("https://9gag.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}