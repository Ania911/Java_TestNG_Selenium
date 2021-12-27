package Tests;

import Base.Base;
import org.testng.annotations.Test;
import verification.Methods;
import verification.Verification;


public class testNavigation extends Base {
    Verification verification = new Verification();
    Methods function = new Methods();

    @Test
    public void testUrlLinkHot() {
        function.clickOnTheButton(homePage.hotButton);
        homePage.verifyHotUrl();
        verification.verifyElementIsPresent(homePage.spiderManButton);
        verification.verifyElementIsPresent(homePage.omicronButton);
    }

    @Test
    public void testUrlLinkTrending() {
        function.clickOnTheButton(homePage.trendingButton);
        homePage.verifyTrendingUrl();
    }

    @Test
    public void testOpenCommentNewPage() {
        function.clickOnTheButton(homePage.commentButton);
        homePage.switchToCommentPage();
        commentPage.verifyCommentPageUrl();
    }

    @Test
    public void testNavigationBackAndForward() {
        homePage.navigateBackAndForward();
    }

    @Test
    public void testNavigationToLink() {
        homePage.navigateToFunnyUrl();
    }

}
