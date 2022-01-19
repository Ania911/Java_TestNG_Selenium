package Tests;

import Base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.CommentPage;
import pageObjects.HomePage;
import utility.Methods;
import utility.Verification;


public class testNavigation extends Base {
    @AfterMethod
    public void backToHomePage() {
        driver.get("https://9gag.com/");
    }

    @Test
    public void testUrlLinkHot() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButtonWithoutWait(homePage.hotButton);
        homePage.verifyHotUrl();
        Verification.verifyElementIsPresent(homePage.omicronButton);
    }

    @Test
    public void testUrlLinkTrending() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButtonWithoutWait(homePage.trendingButton);
        homePage.verifyTrendingUrl();
    }

    @Test
    public void testOpenCommentNewPage() {
        HomePage homePage = new HomePage(driver);
        CommentPage commentPage = new CommentPage(driver);
        homePage.commentButton.click();
        Methods function = new Methods(driver);
        function.switchToCommentPage();
        commentPage.verifyCommentPageUrl();
    }

    @Test
    public void testNavigationBackAndForward() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateBackAndForward();
    }

    @Test
    public void testNavigationToLink() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToFunnyUrl();
    }

}
