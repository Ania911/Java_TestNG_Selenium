package Tests;

import Base.Base;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SubMenuPage;
import utility.Methods;
import utility.Verification;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Epic("SubMenu")
@Feature("SubMenu button functionality")
public class testSubMenu extends Base {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testMenuIconPresent() {
        HomePage homePage = new HomePage(driver);
        Verification.verifyElementIsPresent(homePage.menuButton);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testSubMenuHiding() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.menuButton);
        assertFalse(function.elementIsNotDisplayed(homePage.hotLabel));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testButtonIsSelected() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.hotLabel);
        assertTrue(Methods.elementIsSelected(homePage.hotButton));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testIconMoreOptionsForHotLabel() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.hotLabel);
        SubMenuPage subMenuPage = new SubMenuPage(driver);
        function.clickTheButton(subMenuPage.iconMore);
        Verification.verifyText("Top Posts", subMenuPage.topPosts);
        Verification.verifyText("Most Recent", subMenuPage.mostRecent);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testOptionMenuIsHide() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.hotLabel);
        SubMenuPage subMenuPage = new SubMenuPage(driver);
        function.clickTheButton(subMenuPage.iconMore);
        function.clickTheButton(subMenuPage.mostRecent);
        assertFalse(function.elementIsNotDisplayed(subMenuPage.menu));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testFavoriteTextIsPresent() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.starIcon);
        function.elementIsDisplayed(homePage.favoriteText);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testMarkAsFavorite() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
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
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.starIcon);
        function.clickTheButton(homePage.favoriteButton);
        assertFalse(function.elementIsNotDisplayed(homePage.favoriteButton));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testRecentView() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.funnyButton);
        function.elementIsDisplayed(homePage.recentText);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testClearRecentView() {
        //TODO: This test is very slow, try to figure out why.
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.funnyButton);
        function.clickTheButton(homePage.buttonClear);
        function.acceptAlert();
        assertFalse(function.elementIsNotDisplayed(homePage.recentText));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testDismissClearRecentView() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.funnyButton);
        function.clickTheButton(homePage.buttonClear);
        function.alertClickToDismiss();
        function.elementIsDisplayed(homePage.recentText);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testClearRecentViewIconCloseButton() {
        HomePage homePage = new HomePage(driver);
        Methods function = new Methods(driver);
        function.clickTheButton(homePage.funnyButton);
        function.moveToElement(homePage.funnyButton);
        homePage.iconClose.click();
        assertFalse(function.elementIsNotDisplayed(homePage.recentText));
    }

}
