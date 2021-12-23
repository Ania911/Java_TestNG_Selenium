package Tests;

import Base.Base;
import org.testng.annotations.Test;
import verification.Verification;

public class testComments extends Base {

    Verification verification = new Verification();

    @Test
    public void testCommentText() {
        homePage.clickOnCommentButton();
        commentPage.verifyComment();
    }

    @Test
    public void testViewHideAllReplies() {
        homePage.clickOnCommentButton();
        commentPage.verifyAllReplies();
    }

}
