package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import javax.swing.text.Highlighter;


public class Base {

    private WebDriver driver;

    @BeforeMethod
    public void setUp ()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver ();
        driver.get("https://9gag.com/");
    }


    @AfterMethod
    public void tearDown ()
    {
        driver.quit();
    }
}