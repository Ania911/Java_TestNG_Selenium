package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class Base {

    protected WebDriver driver;
    //TODO: Try to do browser setup and teardown in @BeforeClass and @AfterClass.
    // And in each class add @BeforeMethod with code that will recreate needed starting position,
    // e.g. driver.get("https://9gag.com/");

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://9gag.com/");
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