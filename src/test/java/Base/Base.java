package Base;

import PageFactory.CommentPage;
import PageFactory.HomePage;
import PageFactory.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class Base {

    protected SignUpPage signUpPage;
    protected HomePage homePage;
    protected CommentPage commentPage;

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
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}