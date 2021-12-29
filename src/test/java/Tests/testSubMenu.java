package Tests;

import Base.Base;
import org.testng.annotations.Test;
import verification.Methods;
import verification.Verification;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class testSubMenu extends Base {

    Verification verification = new Verification();
    Methods function = new Methods();

    @Test
    public void testMenuIconPresent() {
        verification.verifyElementIsPresent(homePage.menuButton);
    }

    @Test
    public void testSubMenuHiding() {
        function.clickOnTheButton(homePage.menuButton);
        assertFalse(function.elementIsDisplayed(homePage.hotLabel));
    }

    @Test
    public void testButtonIsSelected() {
        function.clickOnTheButton(homePage.hotLabel);
        assertTrue(function.elementIsSelected(homePage.hotButton));
    }

    @Test
    public void testIconMoreOptionsForHotLabel() {
        function.clickOnTheButton(homePage.hotLabel);
        function.clickOnTheButton(subMenuPage.iconMore);
        verification.verifyText("Top Posts", subMenuPage.topPosts);
        verification.verifyText("Most Recent", subMenuPage.mostRecent);
    }

    @Test
    public void testOptionMenuIsHide() {
        function.clickOnTheButton(homePage.hotLabel);
        function.clickOnTheButton(subMenuPage.iconMore);
        function.clickOnTheButton(subMenuPage.mostRecent);
        assertFalse(function.elementIsDisplayed(subMenuPage.menu));
    }

    @Test
    public void testFavoriteTextIsPresent() {
        function.clickOnTheButton(homePage.starIcon);
        assertTrue(function.elementIsDisplayed(homePage.favoriteText));
    }

    @Test
    public void testMarkAsFavorite() {
        function.clickOnTheButton(homePage.starIcon);
        assertTrue(function.elementIsDisplayed(homePage.favoriteButton));
    }

    @Test
    public void testCheckUncheckAsFavorite() {
        function.clickOnTheButton(homePage.starIcon);
        assertTrue(function.elementIsDisplayed(homePage.favoriteButton));
        function.clickOnTheButton(homePage.favoriteButton);
        assertFalse(function.elementIsDisplayed(homePage.favoriteButton));
    }

    @Test
    public void testRecentView() {
        function.clickOnTheButton(homePage.funnyButton);
        assertTrue(function.elementIsDisplayed(homePage.recentText));
    }
//JavaScript popup
    @Test
    public void testClearRecentView() {
        function.clickOnTheButton(homePage.funnyButton);
        function.clickOnTheButton(homePage.buttonClear);
        assertFalse(function.elementIsDisplayed(homePage.recentText));
    }

}
