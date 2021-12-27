package Tests;

import Base.Base;
import org.testng.annotations.Test;
import verification.Methods;
import verification.Verification;

public class testComments extends Base {

    Methods function = new Methods();

    @Test
    public void testCommentText() {
        function.clickOnTheButton(homePage.commentButton);
        homePage.switchToCommentPage();
        commentPage.verifyComment();
    }

    @Test
    public void testViewHideAllReplies() {
        function.clickOnTheButton(homePage.commentButton);
        homePage.switchToCommentPage();
        commentPage.verifyAllReplies();
    }

}
