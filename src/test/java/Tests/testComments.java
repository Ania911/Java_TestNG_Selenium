package Tests;

import Base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CommentPage;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import utility.Methods;


public class testComments extends Base {

    private  CommentPage commentPage;
    private HomePage homePage;
    private Methods function;

    @BeforeMethod
    public void setUp() {
        commentPage = new CommentPage(driver);
        function = new Methods(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDownAfter() {
        commentPage = null;
        function = null;
        homePage = null;
    }

    @Test
    public void testCommentText() {
        function.clickTheButton(homePage.commentButton);
        function.switchToCommentPage();
        commentPage.verifyComment();
    }

    @Test
    public void testViewHideAllReplies() {
        function.clickTheButton(homePage.commentButton);
        function.switchToCommentPage();
        commentPage.verifyAllReplies();
    }

}
