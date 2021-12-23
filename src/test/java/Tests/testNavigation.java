package Tests;

import Base.Base;
import org.testng.annotations.Test;


public class testNavigation extends Base {

    @Test
    public void testUrlLinkHot() {
        homePage.clickOnHotButton();
        homePage.verifyHotUrl();
        homePage.verifyHotButtons();
    }

    @Test
    public void testUrlLinkTrending() {
        homePage.clickOnTrendingButton();
        homePage.verifyTrendingUrl();
    }

    @Test
    public void testOpenCommentNewPage() {
        homePage.clickOnCommentButton();
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
