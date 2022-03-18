package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class WebDriverFactory {
    private final String browser;
    public WebDriver driver;

    public WebDriverFactory(String browser, String platform) {
        this.browser = browser;
        configureDriver(browser, platform);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void configureDriver(String browser, String platform) {

        if (platform.equals("win") & browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (platform.equals("win") & browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (platform.equals("win") & browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
//        } else if (platform.equals("mac") & browser.equalsIgnoreCase("Edge")) {
//            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
//            driver = new EdgeDriver();
//        } else if (platform.equals("mac") & browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//            driver = new FirefoxDriver();
//        } else if (platform.equals("mac") & browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//            driver = new ChromeDriver();
        }
//
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

}
