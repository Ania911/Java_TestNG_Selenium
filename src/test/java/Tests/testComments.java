package Tests;

import Base.Base;
import io.qameta.allure.Attachment;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.CommentPage;
import pageObjects.HomePage;
import utility.Methods;


public class testComments extends Base {

    @Test
    public void testCommentText() {
        CommentPage commentPage = new CommentPage(driver);
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButtonWithoutWait(homePage.commentButton);
        function.switchToCommentPage();
        commentPage.verifyComment();
    }

    @Test
    public void testViewHideAllReplies() {
        CommentPage commentPage = new CommentPage(driver);
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButtonWithoutWait(homePage.commentButton);
        function.switchToCommentPage();
        commentPage.verifyAllReplies();
    }

}
