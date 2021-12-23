package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import verification.Verification;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CommentPage {
  Verification verificationCheck = new Verification();

    private WebDriver driver;
    @FindBy(xpath = "//div[@class = 'comment-list-item__replies']")
    public WebElement viewAllDropDawn;

    @FindBy(xpath = "//div[@class = 'comment-list-item__text']")
    public WebElement commentsList;

    @FindBy(xpath = "//span[@class = 'arrow-down']")
    public WebElement arrowDown;

    @FindBy(xpath = "//span[@class = 'arrow-down arrow-down-reverse']")
    public WebElement arrowDownReverse;


    public CommentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCommentPageUrl() {
        String commentUrl = driver.getCurrentUrl();
        verificationCheck.verifyCommentUrl(commentUrl, "https://9gag.com/");
    }

    public String getCommentText() {
        return verificationCheck.getText(commentsList);
    }

    public  void verifyComment(){
        String title = getCommentText();
        assertEquals(title, getCommentText());
    }

    public void verifyAllReplies() {
        arrowDown.click();
        verificationCheck.verifyElementIsPresent(arrowDownReverse);
    }


}
