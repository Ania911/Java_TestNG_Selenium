package Base;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Base {

    protected WebDriver driver;
    public static final String Base_Url = "https://9gag.com/";

    //Done: Try to do browser setup and teardown in @BeforeClass and @AfterClass.
    // And in each class add @BeforeMethod with code that will recreate needed starting position,
    // e.g. driver.get("https://9gag.com/");

    @BeforeClass
    @Parameters(value = {"browser", "platform"})
    public void setUp(@Optional("browser") String browser, @Optional("platform") String platform) {

        driver = new WebDriverFactory(browser, platform).getDriver();
        driver.manage().window().maximize();
        driver.get(Base_Url);
    }

//yes, you can use this method in @BeforeMethod in each test that you need it. But maybe, in some tests
// you will need to go to some other page. So, it will be good to add some needed links as Constants and pass them
// as parameters like goToPage(String page) {driver.get(page);}

    public void backToHomePage(String page) {
        driver.get(page);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}