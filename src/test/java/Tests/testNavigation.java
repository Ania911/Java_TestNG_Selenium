package Tests;

import Base.Base;
import org.testng.annotations.Test;


public class testNavigation extends Base {

    @Test
    public void testUrlLinkHot() {
        homePage.clickOnHotButton();
    }

    @Test
    public void testUrlLinkTrending() {
        homePage.clickOnTrendingButton();
    }

    @Test
    public void testOpenCommentNewPage() {
        homePage.clickOnCommentButton();
        commentPage.getPageUrl();
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
