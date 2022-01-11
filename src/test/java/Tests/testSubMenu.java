package Tests;

import Base.Base;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SubMenuPage;
import utility.Methods;
import utility.Verification;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class testSubMenu extends Base {


    @Test
    public void testMenuIconPresent() {
        HomePage homePage = new HomePage(driver);
        Verification.verifyElementIsPresent(homePage.menuButton);
    }

    @Test
    public void testSubMenuHiding() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.menuButton);
        assertFalse(Methods.elementIsDisplayed(homePage.hotLabel));
    }

    @Test
    public void testButtonIsSelected() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.hotLabel);
        assertTrue(Methods.elementIsSelected(homePage.hotButton));
    }

    @Test
    public void testIconMoreOptionsForHotLabel() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.hotLabel);
        SubMenuPage subMenuPage = new SubMenuPage(driver);
        Methods.clickOnTheButton(subMenuPage.iconMore);
        Verification.verifyText("Top Posts", subMenuPage.topPosts);
        Verification.verifyText("Most Recent", subMenuPage.mostRecent);
    }

    @Test
    public void testOptionMenuIsHide() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.hotLabel);
        SubMenuPage subMenuPage = new SubMenuPage(driver);
        Methods.clickOnTheButton(subMenuPage.iconMore);
        Methods.clickOnTheButton(subMenuPage.mostRecent);
        assertFalse(Methods.elementIsDisplayed(subMenuPage.menu));
    }

    @Test
    public void testFavoriteTextIsPresent() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.starIcon);
        assertTrue(Methods.elementIsDisplayed(homePage.favoriteText));
    }

    @Test
    public void testMarkAsFavorite() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.starIcon);
        assertTrue(Methods.elementIsDisplayed(homePage.favoriteButton));
    }

    @Test
    public void testCheckUncheckAsFavorite() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.starIcon);
        assertTrue(Methods.elementIsDisplayed(homePage.favoriteButton));
        Methods.clickOnTheButton(homePage.favoriteButton);
        assertFalse(Methods.elementIsDisplayed(homePage.favoriteButton));
    }

    @Test
    public void testRecentView() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.funnyButton);
        assertTrue(Methods.elementIsDisplayed(homePage.recentText));
    }

    @Test
    public void testClearRecentView() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.funnyButton);
        Methods.clickOnTheButton(homePage.buttonClear);
        Methods function = new Methods(driver);
        function.acceptAlert();
        assertFalse(Methods.elementIsDisplayed(homePage.recentText));
    }

    @Test
    public void testDismissClearRecentView() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.funnyButton);
        Methods.clickOnTheButton(homePage.buttonClear);
        Methods function = new Methods(driver);
        function.alertClickToDismiss();
        assertTrue(Methods.elementIsDisplayed(homePage.recentText));
    }

    @Test
    public void testClearRecentViewIconCloseButton() {
        HomePage homePage = new HomePage(driver);
        Methods.clickOnTheButton(homePage.funnyButton);
        Methods function = new Methods(driver);
        function.moveToElement(homePage.funnyButton);
        Methods.clickOnTheButton(homePage.iconClose);
        assertFalse(Methods.elementIsDisplayed(homePage.recentText));
    }

}
