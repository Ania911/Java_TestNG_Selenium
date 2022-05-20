package Tests;

import Base.Base;
import com.sun.source.tree.AssertTree;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import pageObjects.SubMenuPage;
import utility.Methods;
import utility.Verification;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Epic("SubMenu")
@Feature("SubMenu button functionality")
public class testSubMenu extends Base {

    private HomePage homePage;
    private Methods function;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        function = new Methods(driver);
    }

    @AfterMethod
    public void tearDownAfter() {
        homePage = null;
        function = null;
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testMenuIconPresent() {
        function.elementIsDisplayed(homePage.menuButton);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testSubMenuHiding() {
        function.clickTheButton(homePage.menuButton);
        assertFalse(function.elementIsNotDisplayed(homePage.hotLabel));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testButtonIsSelected() {
        function.clickTheButton(homePage.hotLabel);
        function.elementIsDisplayed(homePage.selectedLabel);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testIconMoreOptionsForHotLabel() {
        function.clickTheButton(homePage.hotLabel);
        SubMenuPage subMenuPage = new SubMenuPage(driver);
        function.clickTheButton(subMenuPage.iconMore);
        Verification.verifyText("Top Posts", subMenuPage.topPosts);
        Verification.verifyText("Most Recent", subMenuPage.mostRecent);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testOptionMenuIsHide() {
        function.clickTheButton(homePage.hotLabel);
        SubMenuPage subMenuPage = new SubMenuPage(driver);
        function.clickTheButton(subMenuPage.iconMore);
        function.clickTheButton(subMenuPage.mostRecent);
        assertFalse(function.elementIsNotDisplayed(subMenuPage.menu));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testFavoriteTextIsPresent() {
        function.clickTheButton(homePage.starIcon);
        function.elementIsDisplayed(homePage.favoriteText);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testMarkAsFavorite() {
        if (homePage.favoriteButton.isDisplayed()) {
            function.clickTheButton(homePage.starIcon);
        } else {
            function.clickTheButton(homePage.starIcon);
            assertTrue(homePage.favoriteButton.isDisplayed());
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testCheckUncheckAsFavorite() {
        function.clickTheButton(homePage.starIcon);
        function.clickTheButton(homePage.favoriteButton);
        assertFalse(function.elementIsNotDisplayed(homePage.favoriteButton));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testRecentView() {
        function.clickTheButton(homePage.funnyButton);
        function.elementIsDisplayed(homePage.recentText);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testClearRecentView() {
        //Done: This test is very slow, try to figure out why.
        function.clickTheButton(homePage.funnyButton);
        function.clickTheButton(homePage.buttonClear);
        function.acceptAlert();
        assertFalse(function.elementIsNotDisplayed(homePage.recentText));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testDismissClearRecentView() {
        function.clickTheButton(homePage.funnyButton);
        function.clickTheButton(homePage.buttonClear);
        function.alertClickToDismiss();
        function.elementIsDisplayed(homePage.recentText);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testClearRecentViewIconCloseButton() {
        function.clickTheButton(homePage.funnyButton);
        function.moveToElement(homePage.funnyButton);
        homePage.iconClose.click();
        assertFalse(function.elementIsNotDisplayed(homePage.recentText));
    }

}
