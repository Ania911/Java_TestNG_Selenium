package Tests;

import Base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utility.Methods;


public class testNavigation extends Base {

    private HomePage homePage;
    private Methods function;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        function = new Methods(driver);
    }

    @AfterMethod
    public void tearDownAfter() {
        driver.get("https://9gag.com/");
        homePage = null;
        function = null;
    }

    @Test
    public void testSelectHotButton() {
        function.clickTheButton(homePage.hotButton);
        function.elementIsDisplayed(homePage.selectedButton);
    }

    @Test
    public void testUrlLinkTrending() {
        function.clickTheButton(homePage.trendingButton);
        homePage.verifyUrl("https://9gag.com/");
    }


    @Test
    public void testNavigationBackAndForward() {
        homePage.navigateBackAndForward("https://9gag.com/", "https://9gag.com/hot");
    }

    @Test
    public void testNavigationToLink() {
        homePage.navigateToFunnyUrl();
    }

}
