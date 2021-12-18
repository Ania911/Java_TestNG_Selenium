package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CommentPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@class = 'comment-list-item__replies']")
    WebElement viewAllDropDawn;

    @FindBy(xpath = "//div[@class = 'comment-list-item__text']")
    WebElement commentsList;

    @FindBy(xpath = "//span[@class = 'arrow-down']")
    WebElement arrowDown;

    @FindBy(xpath = "//span[@class = 'arrow-down arrow-down-reverse']")
    WebElement arrowDownReverse;


    public CommentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getPageUrl() {
        String commentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(commentUrl, "https://9gag.com/");
    }

    public String getCommentText() {
        return commentsList.getText();
    }

    public void viewAllReplies() {
        arrowDown.click();
        assertTrue(arrowDownReverse.isDisplayed());
    }


}
