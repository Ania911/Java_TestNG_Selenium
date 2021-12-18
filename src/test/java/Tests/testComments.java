package Tests;

import Base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testComments extends Base {

    @Test
    public void testCommentText() {
        homePage.clickOnCommentButton();
        commentPage.getCommentText();
        String title = commentPage.getCommentText();
        Assert.assertEquals(title, commentPage.getCommentText());
    }

    @Test
    public void testViewHideAllReplies() {
        homePage.clickOnCommentButton();
        commentPage.viewAllReplies();
    }

}
